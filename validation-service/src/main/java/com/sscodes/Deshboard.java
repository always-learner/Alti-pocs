package com.sscodes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ssharma6757 on 10/9/2019.
 */
@RestController
public class Deshboard {

    @Autowired
    private LoginServiceCaller caller;

    @GetMapping(path = "/deshboard/{username}/{password}")
    public String showDeshBoard(@PathVariable String username, @PathVariable String password){
        return caller.getDashboard(username, password);
    }
}
