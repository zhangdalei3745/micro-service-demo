package com.jdcloud.jmsf.consul.cloud.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.net.URI;

@RestController
public class DemoConsulController {
    @Value("${provider.server.name:-}")
    private String privider;
    private boolean health = true;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/call")
    public String info(){
        String appNameEnv = "APP_GROUP";
        String appGroupEnv = "APP_GROUP";
        if (health) {
            if ("-".equals(privider)) {
                return String.format("%s-%s", System.getenv(appNameEnv), System.getenv(appGroupEnv));
            }
            URI consumer = URI.create(String.format("http://%s/call", privider));
            String result = restTemplate.getForObject(consumer, String.class);
            return String.format("%s-%s, %s", System.getenv(appNameEnv), System.getenv(appGroupEnv), result);
        } else {
            throw new InterErrorException();
        }
    }

    @GetMapping("/health/{status}")
    public boolean changeStatus(@PathVariable boolean status){
        health = status;
        return health;
    }
}
