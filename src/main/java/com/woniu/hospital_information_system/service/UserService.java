package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.Tokens;
import com.woniu.hospital_information_system.entity.User;

import javax.security.auth.login.LoginException;

public interface UserService {
    Tokens login(User user) throws LoginException;

    int findEmail(String email);

    void updatepwd(String s, String email);
}
