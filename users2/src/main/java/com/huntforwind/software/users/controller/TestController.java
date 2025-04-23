package com.huntforwind.software.users.controller;

import com.huntforwind.software.users.feign.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    @Autowired
    private OrderClient orderClient;

    @GetMapping("/first")
    public String first() {
        return "user2";
//        return this.orderClient.first();
    }
}
