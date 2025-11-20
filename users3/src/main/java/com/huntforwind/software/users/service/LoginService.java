package com.huntforwind.software.users.service;

import java.util.Map;

public interface LoginService {

    Map<String, String> loginByUsernameAndPassword(String username, String password);

    String logout();
}
