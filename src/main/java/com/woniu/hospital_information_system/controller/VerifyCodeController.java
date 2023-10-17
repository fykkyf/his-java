package com.woniu.hospital_information_system.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.RandomUtil;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.VerifyCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class VerifyCodeController {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    VerifyCode verifyCode;
    @RequestMapping("/verifycode")
    public ResponseEntity createVerifyCode() throws IOException {
        ICaptcha captcha = CaptchaUtil.createLineCaptcha(200, 100, 4, 150);
        String verifycode = captcha.getCode();
        log.info("verifycode={}", verifycode);
        String uuid = UUID.randomUUID().toString().replace("-", "");
        redisTemplate.opsForValue().set(uuid,verifycode,3, TimeUnit.MINUTES);
        try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream()){
            captcha.write(outputStream);
            String verifycodesrc = Base64.encode(outputStream.toByteArray());
            return new ResponseEntity(200,"ok",new VerifyCode(verifycodesrc,uuid));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static String generateCode(int length) {
        return RandomUtil.randomNumbers(length);
    }
}