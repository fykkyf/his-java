package com.woniu.hospital_information_system.controller;

import cn.hutool.http.server.HttpServerResponse;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.Tokens;
import com.woniu.hospital_information_system.entity.User;
import com.woniu.hospital_information_system.service.UserService;
import com.woniu.hospital_information_system.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.AuthProvider;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    UserService userService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user, HttpServerResponse response){
        if(!user.getVerifycode().equals(redisTemplate.opsForValue().get(user.getUuid()))){
            return new ResponseEntity(500,"验证码错误","");
        }else {
            redisTemplate.delete(user.getUuid());
        }

        Tokens tokens = userService.login(user);
        response.setHeader("token",tokens.getToken1());
        response.setHeader("refresh",tokens.getToken2());
        response.setHeader("Access-Control-Expose-Headers","*");

        return new ResponseEntity(200,"success","login!");
    }
}
