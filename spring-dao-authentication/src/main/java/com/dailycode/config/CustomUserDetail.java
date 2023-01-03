package com.dailycode.config;

import com.dailycode.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Slf4j
public class CustomUserDetail implements UserDetails {

    private User user;

    public CustomUserDetail(User user) {
        super();
        log.info("[CustomUserDetail] : CustomUserDetail Constructor");
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        log.info("[CustomUserDetail] : getAuthorities");
        return Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
    }

    @Override
    public String getPassword() {
        log.info("[CustomUserDetail] : getPassword");
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        log.info("[CustomUserDetail] : getPassword");
        return user.getUsername();
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
