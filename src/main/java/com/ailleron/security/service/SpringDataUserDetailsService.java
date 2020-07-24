package com.ailleron.security.service;

import com.ailleron.security.domain.CurrentUser;
import com.ailleron.security.domain.Privilege;
import com.ailleron.security.domain.Role;
import com.ailleron.security.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;

public class SpringDataUserDetailsService implements UserDetailsService {

    private UserService userService;

    @Autowired
    public void setUserRepository(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findEnabledUsersByUserName(username);
        if (user == null){ throw new UsernameNotFoundException(username); }
        //Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<GrantedAuthority> grantedAuthorities = (Set<GrantedAuthority>) getAuthorities(user.getRoles());

        //user.getRoles().forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.getName())));
        return new CurrentUser(user.getUserName(),user.getPassword(),
                grantedAuthorities, user);
    }

    private List<String> getPrivileges(Set<Role> roles){
        List<Privilege> list = new ArrayList<>();
        List<String> privileges = new ArrayList<>();
        roles.forEach(role -> list.addAll(role.getPrivileges()));
        list.forEach(l -> privileges.add(l.getName()));
        return privileges;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {
        Set<GrantedAuthority> authorities
                = new HashSet<>();
        for (Role role: roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            role.getPrivileges().stream()
                    .map(p -> new SimpleGrantedAuthority(p.getName()))
                    .forEach(authorities::add);
        }

        return authorities;
    }

}
