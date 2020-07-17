package com.ailleron.security.service;

import com.ailleron.security.domain.User;
import com.ailleron.security.repository.RoleRepository;
import com.ailleron.security.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    // private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        // this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUserName(String name) {
        return userRepository.findByUserName(name);
    }

    @Override
    public void saveUser(User user) {

    }
}
