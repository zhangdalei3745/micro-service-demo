package com.jdcloud.jmsf.consul.cloud.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "not health")
public class InterErrorException extends RuntimeException {

}
