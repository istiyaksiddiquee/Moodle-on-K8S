package com.magnumopus.usermanagement.controllers;


import com.magnumopus.usermanagement.models.User;
import com.magnumopus.usermanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addHuman")
    public User createUserInstance(User user) {
        return userService.persistUser(user);
    }
    
    @GetMapping("/getAllHuman")
    public List<User> getAllUser() {
        return userService.findAllUser();
    }

    @RequestMapping(path="/getByUserName/{userName}")
    public User getAllUser(@PathVariable("userName") String userName) {
        return userService.getUserByUserName(userName);
    }
}