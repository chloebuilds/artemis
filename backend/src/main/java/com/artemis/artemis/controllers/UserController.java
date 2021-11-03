package com.artemis.artemis.controllers;

import com.artemis.artemis.models.User;
import com.artemis.artemis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // FIND ALL
    @GetMapping("/users")
    public Iterable<User> getUsers() { return userService.findAllUsers(); }

    // POST
    @PostMapping("/users")
    // @RequestBody allows Spring to automatically deserialize the HTTP request body into a Java object which can be bound to the method and further processed
    public User postUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    // GET BY ID
    @GetMapping("/users/{userId}")
    public Optional<User> getUser(@PathVariable Integer userId) {

        return userService.findUser(userId);
    }

    // DELETE
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Integer userId) {

        userService.deleteUser(userId);
    }

    // EDIT
    @PutMapping("/users/{userId}")
    public User putUser(@PathVariable Integer userId,
                        @RequestBody User user) {
        return userService.updateUser(userId, user);
    }
}
