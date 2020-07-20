package com.ailleron.security.controller;

import com.ailleron.security.domain.User;
import com.ailleron.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class UserController {

    /* Users - password:
    user - user
    admin - admin
    viewer - viewer
     */

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

    @GetMapping("/user-info")
    @ResponseBody
    public String userInfo(@AuthenticationPrincipal UserDetails customUser){
        log.info("customUser class {} " , customUser.getClass());
        return "You are logged as " + customUser;
    }
}
