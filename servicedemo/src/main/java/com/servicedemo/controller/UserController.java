package com.servicedemo.controller;

import com.servicedemo.exception.UserNotFoundException;
import com.servicedemo.model.User;
import com.servicedemo.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping(path = "users")
    public void addNewUser(@Valid @RequestBody final User user){
        Objects.requireNonNull(user);
        LOGGER.info("Incoming request for adding new user "+user);
        userService.addNewUser(user);
    }

    @GetMapping(path = "users")
    public List<User> fetchAllUsers(){
        LOGGER.info("Incoming request for fetching all users ");
        return userService.getAllUsers();
    }

    @GetMapping(path = "users/{id}")
    public ResponseEntity<User> fetchUserById(@PathVariable final Long id) {
        LOGGER.info("Incoming request for fetching th user by user id "+ id);
        final User userById = userService.getUserById(id);
        if (Objects.isNull(userById)){
            throw new UserNotFoundException("User not does not exists ");
        }
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @PutMapping(path = "users")
    public void updateUserDetails(@Valid @RequestBody final User user){
        LOGGER.info("Incoming request for updating the existing user details for user  "+ user);
        userService.updateUser(user);
    }

    @DeleteMapping(path = "users/{id}")
    public void deleteUserById(@PathVariable final Long id){
        LOGGER.info("Incoming request for deleting user by id "+id);
        userService.removeUserById(id);
    }
}
