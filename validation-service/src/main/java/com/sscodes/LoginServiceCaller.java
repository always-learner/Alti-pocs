package com.sscodes;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by ssharma6757 on 10/9/2019.
 */
@FeignClient(name = "login-service")
@RibbonClient(name = "login-service")
public interface LoginServiceCaller {

    @GetMapping(path = "/login/{username}/{password}")
    String getDashboard(@PathVariable(value = "username") String username, @PathVariable(value = "password") String password);
}
