package com.huntforwind.software.users.service.impl;

import com.huntforwind.software.users.bean.LoginUser;
import com.huntforwind.software.users.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!"HuntForWind".equals(username)) {
            throw new UsernameNotFoundException(username);
        }
        User user = new User();
        user.setId(1);
        user.setUsername("HuntForWind");
        user.setPassword(passwordEncoder.encode("310318"));
        return new LoginUser(user);
    }
}
