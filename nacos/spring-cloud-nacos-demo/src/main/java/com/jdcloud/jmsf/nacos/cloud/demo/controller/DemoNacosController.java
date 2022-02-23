package com.jdcloud.jmsf.nacos.cloud.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
public class DemoNacosController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/{svc}")
    public String hello(@PathVariable String svc){
        try {
            URI consumer = URI.create(String.format("http://%s", svc));
            return restTemplate.getForObject(consumer, String.class);
        } catch (Exception e) {
            return  "fail back，hello";
        }
    }

    @GetMapping()
    public String call(){
        return "hello";
    }
}
