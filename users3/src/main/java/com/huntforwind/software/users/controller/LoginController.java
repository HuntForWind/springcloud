package com.huntforwind.software.users.controller;

import com.huntforwind.software.users.bean.User;
import com.huntforwind.software.users.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/byUsernameAndPassword")
    public Map<String, String> loginByUsernameAndPassword(@RequestBody User user) {
        return this.loginService.loginByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
