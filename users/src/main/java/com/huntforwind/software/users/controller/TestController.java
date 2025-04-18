package com.huntforwind.software.users.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @CircuitBreaker(name = "myBackend", fallbackMethod = "fallbackMethod")
    @GetMapping("/first")
    public String first() throws InterruptedException {
        throw new RuntimeException("异常了");
    }

    public String fallbackMethod(Exception e) {
        return "fallback";
    }
}
