package com.ailleron.security.controller;

import com.ailleron.security.domain.CurrentUser;
import com.ailleron.security.domain.User;
import com.ailleron.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
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
    user0 - user0 enabled=0
    sAdmin - aAdmin
     */

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser(){
        User user = new User();
        user.setUserName("sAdmin");
        user.setPassword("aAdmin");
        userService.saveUser(user);
        return "user0";
    }

    @GetMapping("/user-info")
    @ResponseBody
    public String userInfo(@AuthenticationPrincipal CurrentUser customUser){
        log.info("customUser class {} " , customUser.getClass());
        log.info("custom user authorities {} ", customUser.getAuthorities());
        return "You are logged as " + customUser;
    }
    @GetMapping("/authentication")
    @ResponseBody
    public Object getAuthentication(@CurrentSecurityContext(expression = "authentication")
                                            Authentication authentication) {
        return authentication.getDetails();
    }
}
