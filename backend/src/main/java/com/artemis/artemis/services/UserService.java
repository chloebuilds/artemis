package com.artemis.artemis.services;

import com.artemis.artemis.models.User;
import com.artemis.artemis.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public Iterable<User> findAllUsers() { return userRepo.findAll(); }

    public User createUser(User user) { return userRepo.save(user); }

    public Optional<User> findUser(Integer userId) {
        Optional<User> optUser = userRepo.findById(userId);
        if (optUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return optUser;
    }

    public void deleteUser(Integer userId) {
        Optional<User> optUser = userRepo.findById(userId);
        if (optUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        userRepo.deleteById(userId);
    }

    public User updateUser(Integer userId, User user) {
        Optional<User> optUser = userRepo.findById(userId);
        if (optUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        User userToUpdate = optUser.get();
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setLinkedin(user.getLinkedin());
        userToUpdate.setGithub(user.getGithub());
        userToUpdate.setPortfolio(user.getPortfolio());
        return userRepo.save(userToUpdate);
    }
}
