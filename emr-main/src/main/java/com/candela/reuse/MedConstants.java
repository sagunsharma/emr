package com.candela.reuse;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class MedConstants {

    public static final String AUTH_BASIC = "Basic";
    public static final String AUTH_BEARER = "Bearer";
    public static final String CONTENTTYPE_JSON = "application/json";
    public static final String CONTENTTYPE_FORM = "application/x-www-form-urlencoded";
    public static final String USERAGENT = "TomcatServer/8.5";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_FORWARDEDFOR = "X-FORWARDED-FOR";
    
    public static final int MAX_REQUESTS_PER_SECOND = 5;
      
    public static final String TIME_UTC = "UTC";
    public static final String TIME_IST = "Asia/Calcutta";
    public static final String TIME_IST1 = "Asia/Kolkata";
    
    public static final String FORMAT_DATEPATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";
    
    public static final int USER_ACTIVE = 1;
    public static final int USER_INACTIVE = 0;
    public static final int USER_PENDING = 2;
    public static final int USER_ADMIN = 3;
    public static final int USER_MANAGER = 4;
    
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_SIGNUP = "ROLE_SIGNUP";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_MANAGER = "ROLE_MANAGER";
    public static final String ROLE_INACTIVE = "ROLE_NONE";
}
