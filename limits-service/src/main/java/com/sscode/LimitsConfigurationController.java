package com.sscode;

import com.sscode.model.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private LimitConfiguration limitConfiguration;

    @GetMapping("/limits")
    public LimitConfiguration getLimits(){
        return new LimitConfiguration(limitConfiguration.getMinimum(), limitConfiguration.getMaximum());
    }
}
