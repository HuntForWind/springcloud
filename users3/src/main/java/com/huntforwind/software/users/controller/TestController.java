package com.huntforwind.software.users.controller;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    @PreAuthorize("hasAuthority('first')")
    @GetMapping("/first")
    public String first() {
        return "firstUser3";
    }

    @PreAuthorize("hasAuthority('last')")
    @GetMapping("/last")
    public String last() {
        return "lastUser3";
    }
}
