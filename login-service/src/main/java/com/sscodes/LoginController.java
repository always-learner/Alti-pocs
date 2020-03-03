package com.sscodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private Environment environment;

    @GetMapping("/login/{userName}/{password}")
    public String  isValidUser(@PathVariable String userName, @PathVariable String password){
        return (userName.equals("admin") && password.equals("admin")) + environment.getProperty("local.server.port");
    }
}
