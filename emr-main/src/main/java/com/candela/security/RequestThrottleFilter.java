package com.candela.security;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Component
public class RequestThrottleFilter implements Filter {
    private LoadingCache<String, Integer> requestCountsPerIpAddress;

    public RequestThrottleFilter(){
        super();
        requestCountsPerIpAddress = CacheBuilder.newBuilder()
                                                .expireAfterWrite(1, TimeUnit.SECONDS)
                                                .build(new CacheLoader<String, Integer>()
        {
            public Integer load(String key) {
                return 0;
            }
        });
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // No configuration
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String clientIpAddress = getClientIP((HttpServletRequest) servletRequest);
        if(isMaximumRequestsPerSecondExceeded(request, clientIpAddress)){
          response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
          response.getWriter().write("Too many requests");
          return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isMaximumRequestsPerSecondExceeded(HttpServletRequest request, String clientIpAddress){
        int requests = 0;
        try {
            requests = requestCountsPerIpAddress.get(clientIpAddress);
            if(requests > 5){
                requestCountsPerIpAddress.put(clientIpAddress, requests);
                return true;
            }
        } catch (ExecutionException e) {
            requests = 0;
        }
        if(!request.getRequestURL().toString().contains("/img/") && !request.getRequestURL().toString().contains("/css/") &&
           !request.getRequestURL().toString().contains("/fonts/") && !request.getRequestURL().toString().contains("/js/")) {
            requests++;
            requestCountsPerIpAddress.put(clientIpAddress, requests);
        }
        return false;
    }

    public String getClientIP(HttpServletRequest request) {
        String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null){
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }

    @Override
    public void destroy() {
        // No configuraton
    }
}
