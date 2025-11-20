package com.huntforwind.software.users.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWTUtil;
import com.huntforwind.software.users.bean.LoginUser;
import com.huntforwind.software.users.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    public static Map<String, Object> userInfoMap = new HashMap<>();

    @Override
    public Map<String, String> loginByUsernameAndPassword(String username, String password) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if (!authenticate.isAuthenticated()) {
            throw new RuntimeException("认证失败！");
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        Integer userId = loginUser.getUser().getId();
        userInfoMap.put(StrUtil.toString(userId), loginUser);
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("username", loginUser.getUsername());
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        resultMap.put("token", JWTUtil.createToken(map, "salt".getBytes()));
        return resultMap;
    }
}
