package com.woniu.hospital_information_system.controller;

import cn.hutool.http.server.HttpServerResponse;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.Tokens;
import com.woniu.hospital_information_system.entity.User;
import com.woniu.hospital_information_system.exception.VerifyCodeErrorException;
import com.woniu.hospital_information_system.service.UserService;
import com.woniu.hospital_information_system.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import javax.security.auth.login.LoginException;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    UserService userService;
    @Autowired
    ProducerController producerController;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user, HttpServerResponse response) throws LoginException {
        //验证码校验
        if(!user.getVerifycode().equals(redisTemplate.opsForValue().get(user.getUuid()))){
            //验证失败
            throw new VerifyCodeErrorException("验证码错误");
        }else {
            //验证通过
            redisTemplate.delete(user.getUuid());
        }
        Tokens tokens = userService.login(user);
        response.setHeader("token",tokens.getToken1());
        response.setHeader("refresh",tokens.getToken2());
        response.setHeader("Access-Control-Expose-Headers","*");
        return new ResponseEntity(200,"success","login!");
    }

    @GetMapping("/postemail")
    //重置密码时，验证邮箱
    public ResponseEntity postEmail(String email){
        if (email==null||email.equals("")){
            return new ResponseEntity(407,"error","邮箱不能为空");
        }
        if (!email.matches("\\w+@+\\w+\\.\\w+")){
            return new ResponseEntity(408,"error","邮箱格式有误");
        }
        int num = userService.findEmail(email);
        if (num==0){
            return new ResponseEntity(405,"error","邮箱有误");
        }else {
            //调用生产者
            producerController.sendEmail(email);
            return new ResponseEntity(200,"ok","发送成功");
        }
    }

    @GetMapping("/updatepwd")
    //验证验证码，两次输入的密码，验证成功后，修改密码成功
    public ResponseEntity update(String verificationCode,String newPassword, String newPassword2,String email){
        if (verificationCode==null||verificationCode.equals("")){
            return new ResponseEntity(408,"error","验证码不能为空");
        }
        if (newPassword==null||newPassword.equals("")){
            return new ResponseEntity(410,"error","密码不能为空");
        }
        if (newPassword2==null||newPassword2.equals("")){
            return new ResponseEntity(411,"error","二次确认密码不能为空");
        }
        if (verificationCode.equals(redisUtil.get(email))){
            if (newPassword.equals(newPassword2)){
                String s = DigestUtils.md5DigestAsHex(newPassword.getBytes());
                userService.updatepwd(s,email);
                return new ResponseEntity(200,"ok","修改成功");
            }else {
                return new ResponseEntity(400,"error","密码不一致");
            }
        }else{
            return new ResponseEntity(409,"error","验证码错误");
        }
    }
}
