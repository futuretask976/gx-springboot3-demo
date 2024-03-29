package com.gx.sp3.demo.web.security.model;

import org.assertj.core.util.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class GxUserDetails implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList = Lists.newArrayList();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ADMIN"));
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return "root";
    }

    @Override
    public String getUsername() {
        return "admin";
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
}
