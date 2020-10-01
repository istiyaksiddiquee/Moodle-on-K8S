package com.magnumopus.usermanagement.controllers;


import com.magnumopus.usermanagement.models.User;
import com.magnumopus.usermanagement.services.UserService;
import com.magnumopus.usermanagement.utilities.InputValidator;
import com.magnumopus.usermanagement.utilities.ResponseMessages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    UserService userService;

    @Autowired
    InputValidator inputValidator;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) throws URISyntaxException {

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

    @GetMapping("/")
    public List<User> getAllUser() {
        log.info("intercepted post call to get all user");
        return userService.findAllUser();
    }

    @RequestMapping(path = "/getByUserName/{userName}")
    public User getUserByName(@PathVariable("userName") String userName) {
        return userService.getUserByUserName(userName);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") String userId) {

        String responseMsg = null;
        HttpStatus statusCode = null;
        Integer extractedUserId = inputValidator.validateInteger(userId);
        if (extractedUserId == null) {

            responseMsg = "Invalid Input";
            statusCode = HttpStatus.BAD_REQUEST;
        } else {
            responseMsg = userService.deleteUser(extractedUserId);;
        }
        return ResponseEntity.ok(responseMsg);


    }
}