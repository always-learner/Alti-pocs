package com.mocktest;

import org.springframework.web.client.RestTemplate;

/**
 * Created by ssharma6757 on 12/17/2019.
 */
public class HttpAndHttpsTest {

    public void httpTest(){
        final String uri = "http://localhost:8080/one";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println("Http response "+ result);
    }

    public void httpsTest(){

        final String uri = "https://localhost:8081/two";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println("Https response "+result);
    }
}
