package com.magnumopus.usermanagement.controllers;


import com.magnumopus.usermanagement.models.User;
import com.magnumopus.usermanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {
        User createdStudent = userService.createUser(user);
        if (createdStudent == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdStudent.getUserId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(createdStudent);
        }
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