package com.citi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ssharma6757 on 12/18/2019.
 */

@RestController
public class AggregatorMessageHandler {

    @GetMapping("/b07/{testType}")
    public String handleB07Message(@PathVariable("testType") final String testType){
        final String uri = "http://localhost:8081/"+testType;
        RestTemplate restTemplate = new RestTemplate();
        String result;
        try {
            result = restTemplate.getForObject(uri, String.class);
        } catch(final Exception e){
            return "Http response "+e.getMessage();
        }
        return "Http response "+ result;
    }
}
