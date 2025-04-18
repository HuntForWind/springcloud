package com.huntforwind.software.users.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "order", fallback = OrderClientFallback.class)
public interface OrderClient {
    @GetMapping("/test/first")
    String first();
}
