package com.huntforwind.software.users.controller;

import com.huntforwind.software.users.feign.UsersClient;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Tag(name = "订单")
public class TestController {

    @Autowired
    private UsersClient usersClient;

    @GetMapping("/first")
    public String first() {
        return this.usersClient.first();
    }
}
