package com.magnumopus.usermanagement.controllers;


import com.magnumopus.usermanagement.models.User;
import com.magnumopus.usermanagement.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {

//        logger.info("intercepted post call to create user");

        log.info("intercepted post call to create user");

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
        log.info("intercepted post call to get all user");
        logger.info("intercepted post call to get all human");
        return userService.findAllUser();
    }

    @RequestMapping(path="/getByUserName/{userName}")
    public User getAllUser(@PathVariable("userName") String userName) {
        return userService.getUserByUserName(userName);
    }
}