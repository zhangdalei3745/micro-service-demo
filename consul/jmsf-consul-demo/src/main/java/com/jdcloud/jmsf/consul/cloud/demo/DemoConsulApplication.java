package com.jdcloud.jmsf.consul.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoConsulApplication {

    public static void main(String[] args) {
//        System.setProperty("JMESH_REGISTRY_HOST", "114.67.242.135");
//        System.setProperty("JMESH_REGISTRY_PORT", "8500");
//        System.setProperty("JMESH_CONFIG_TOKEN", "a3c9a52b-6df9-9415-aab1-8e9d6fcd0b7a");
        SpringApplication.run(DemoConsulApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
