package com.huntforwind.software.users.feign;

import org.springframework.stereotype.Component;

@Component
public class UsersClientFallback implements UsersClient {
    @Override
    public String first() {
        return "发生异常了";
    }
}
