package com.huntforwind.software.users.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "users", fallback = UsersClientFallback.class)
public interface UsersClient {
    @GetMapping("/test/first")
    String first();
}
