package com.huntforwind.software.users.filter;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.huntforwind.software.users.bean.LoginUser;
import com.huntforwind.software.users.service.impl.LoginServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");
        if (StrUtil.isBlank(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        String userId;
        try {
            JWT jwt = JWTUtil.parseToken(token);
            userId = StrUtil.toString(jwt.getPayload("userId"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法！");
        }
        LoginUser loginUser = (LoginUser) LoginServiceImpl.userInfoMap.get(userId);
        if (ObjectUtil.isNull(loginUser)) {
            throw new RuntimeException("用户未登录");
        }
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(loginUser, null,
                loginUser.getAuthorities()));
        filterChain.doFilter(request, response);
    }
}
