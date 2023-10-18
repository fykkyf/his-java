package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.Tokens;
import com.woniu.hospital_information_system.entity.User;
import com.woniu.hospital_information_system.exception.PasswordErrorException;
import com.woniu.hospital_information_system.mapper.UserMapper;

import com.woniu.hospital_information_system.service.UserService;
import com.woniu.hospital_information_system.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.security.auth.login.LoginException;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Tokens login(User user) throws LoginException {
        Tokens tokens = new Tokens();
        User user1 = userMapper.login(user);
        if (user1 == null){
            throw new LoginException("用户名不存在");
        }
        if (!DigestUtils.md5DigestAsHex(user.getPassword().getBytes()).equals(user1.getPassword())){
            throw new PasswordErrorException("密码错误");
        }
        String token = JwtUtil.createToken(user1.getUserId().toString(), user1.getUserName());
        String refresh = JwtUtil.createRefreshToken(user1.getUserId().toString(), user1.getUserName());
        tokens.setToken1(token);
        tokens.setToken2(refresh);
        System.out.println(tokens);
        return tokens;
    }

    @Override
    public int findEmail(String email) {
        return userMapper.findEmail(email);
    }

    @Override
    public void updatepwd(String s, String email) {
        userMapper.updatepwd(s,email);
    }


}
