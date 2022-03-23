package com.jdcloud.jmsf.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;

@RestController
public class DemoController {
    public static final String HEADERS = "headers";
    public static final String IP = "ip";
    public static final String USER_AGENT = "user-agent";

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping(HEADERS)
    public HttpHeaders getHeader(ServletRequest req) {
        return getRequestHeaders(req);
    }

    @GetMapping(IP)
    public String getIP() throws UnknownHostException {
        InetAddress addr  = InetAddress.getLocalHost();
        return addr.getHostAddress();
    }

    @GetMapping(USER_AGENT)
    public String getUserAgent(ServletRequest req) {
        HttpHeaders headers = getRequestHeaders(req);
        List<String> result = headers.get("user-agent");
        return result == null? null: result.toString();
    }

    @GetMapping("/call/{svc}")
    public String call(@PathVariable String svc) {
        return restTemplate.getForObject(URI.create(String.format("http://%s/call", svc)), String.class);
    }

    @GetMapping("/calls")
    public String calls() {
        return restTemplate.getForObject(URI.create(String.format("http://%s/call", System.getenv("PROVIDER"))), String.class);
    }


    private HttpHeaders getRequestHeaders(ServletRequest req) {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpHeaders requestHeaders = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            requestHeaders.add(key, value);
        }
       return  requestHeaders;
    }
}
