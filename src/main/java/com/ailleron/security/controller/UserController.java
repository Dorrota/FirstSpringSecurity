package com.ailleron.security.controller;

import com.ailleron.security.domain.User;
import com.ailleron.security.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser(){
        User user = new User();
        user.setUserName("viewer");
        user.setPassword("viewer");
        userService.saveUser(user);
        return "viewer";
    }
}
