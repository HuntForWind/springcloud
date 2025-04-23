package com.huntforwind.software;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Users3Application {

    public static void main(String[] args) {
        SpringApplication.run(Users3Application.class, args);
    }

}
