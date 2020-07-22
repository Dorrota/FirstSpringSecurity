package com.ailleron.security.service;

import com.ailleron.security.domain.User;

public interface UserService {

    User findByUserName(String name);
    User findEnabledUsersByUserName(String name);
    void saveUser(User user);
}
