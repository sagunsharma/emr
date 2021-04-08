package com.candela.reuse;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.candela.entity.User;

public class PortalUserDetails implements UserDetails {
    /**
     * 
     */
    private static final long serialVersionUID = 1919844300701266843L;
    
    private User user;
    
    public PortalUserDetails(User user) {
        this.user = user;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return user.getAuthorities().stream().map(authority -> new SimpleGrantedAuthority(authority.getAuthority())).collect(Collectors.toList());
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        if(user.getStatus() == MedConstants.USER_PENDING) {
            authorities.add(new SimpleGrantedAuthority(MedConstants.ROLE_SIGNUP));
        }
        else if(user.getStatus() == MedConstants.USER_ACTIVE) {
            authorities.add(new SimpleGrantedAuthority(MedConstants.ROLE_USER));
        }
        else if(user.getStatus() == MedConstants.USER_ADMIN) {
            authorities.add(new SimpleGrantedAuthority(MedConstants.ROLE_ADMIN));
        }
        else if(user.getStatus() == MedConstants.USER_MANAGER) {
            authorities.add(new SimpleGrantedAuthority(MedConstants.ROLE_MANAGER));
        }
        else if(user.getStatus() == MedConstants.USER_INACTIVE) {
            authorities.add(new SimpleGrantedAuthority(MedConstants.ROLE_INACTIVE));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    public int getStatus() {
        return user.getStatus();
    }

}
