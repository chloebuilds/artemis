package com.artemis.artemis.controllers;

import com.artemis.artemis.models.User;
import com.artemis.artemis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // FIND ALL
    @GetMapping("/users")
    public Iterable<User> getUsers() { return userService.findAllUsers(); }
}
