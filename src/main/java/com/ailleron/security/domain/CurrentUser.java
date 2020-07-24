package com.ailleron.security.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {

    public final com.ailleron.security.domain.User user;

    public CurrentUser(String username, String password, Collection<? extends GrantedAuthority> authorities, com.ailleron.security.domain.User user) {
        super(username, password, authorities);
        this.user = user;
    }

    public com.ailleron.security.domain.User getUser(){
        return user;
    }
}
