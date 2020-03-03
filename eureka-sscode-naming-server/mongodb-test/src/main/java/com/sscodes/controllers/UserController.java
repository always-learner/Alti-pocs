package com.sscodes.controllers;

import com.sscodes.model.User;
import com.sscodes.repository.BookRepository;
import com.sscodes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ssharma6757 on 11/5/2019.
 */

@RestController
@RequestMapping(value = "/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/create")
    public void addNewUser(@RequestBody User user){
        bookRepository.saveAll(user.getBooks());
        userRepository.save(user);
    }
}
