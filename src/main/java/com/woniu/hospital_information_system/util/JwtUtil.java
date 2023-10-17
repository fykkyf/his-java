package com.woniu.hospital_information_system.util;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.jwt.JWT;

public class JwtUtil {
    public static final String JWT_KEY="woniuxy";
    public static final String JWT_ISSUER="woniuxyzs";
    public static final int JWT_EXPIRE_MILLISECOND=1000*60*30;
    public static final int JWT_EXPIRE_MILLISECOND_REFRESH=1000*60*60;

    public static String createToken(String eid,String ename){
        return JWT
                .create()
                .setKey(JWT_KEY.getBytes())
                .setIssuer(JWT_ISSUER)
                .setIssuedAt(DateTime.now())
                .setExpiresAt(DateTime.now().offset(DateField.MILLISECOND,JWT_EXPIRE_MILLISECOND))
                .setPayload("eid",eid)
                .setPayload("ename",ename)
                .sign();
    }

    public static String createRefreshToken(String eid,String ename){
        return JWT
                .create()
                .setKey(JWT_KEY.getBytes())
                .setIssuer(JWT_ISSUER)
                .setIssuedAt(DateTime.now())
                .setExpiresAt(DateTime.now().offset(DateField.MILLISECOND,JWT_EXPIRE_MILLISECOND_REFRESH))
                .setPayload("eid",eid)
                .setPayload("ename",ename)
                .sign();
    }

    //获取指定payload
    public static String getEid(String token){
        return JWT.of(token).getPayload("eid").toString();
    }

    public static String getEname(String token){
        return JWT.of(token).getPayload("ename").toString();
    }

    //验证是否有效
    public static boolean validate(String token){
        return JWT.of(token).setKey(JWT_KEY.getBytes()).verify();
    }

    //验证是否过期
    public static boolean isExpire(String token){
        return !JWT.of(token).setKey(JWT_KEY.getBytes()).validate(0);
    }

}

