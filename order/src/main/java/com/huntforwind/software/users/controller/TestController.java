package com.huntforwind.software.users.controller;

import com.huntforwind.software.users.feign.UsersClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UsersClient usersClient;

    @GetMapping("/first")
    public String first() {
        return this.usersClient.first();
    }
}
