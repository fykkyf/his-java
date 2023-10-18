package com.woniu.hospital_information_system.interceptor;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniu.hospital_information_system.util.JwtUtil;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("LoginInterceptor");

        if (request.getMethod().equals("OPTIONS")){
            log.info("OPTIONS，放行");
            return true;
        }
        response.setContentType("text/html;charset=utf-8");
        String token = request.getHeader("token");
        String refresh = request.getHeader("refresh");
        log.info(token);
        log.info(refresh);
        if(!StringUtils.isEmpty(token)&& JwtUtil.validate(token)){
            log.info("token有效，验证是否过期");
            if(!JwtUtil.isExpire(token)){
                log.info("token没有过期，放行");
                return true;
            }else{
                log.info("token有效,token过期，验证refreshToken");
                if (!StringUtils.isEmpty(refresh)&&!JwtUtil.isExpire(refresh)){
                log.info("token有效，token过期，验证refresh,refresh有效，refresh没有过期，重新生成双token");
                token=JwtUtil.createToken(JwtUtil.getEid(token),JwtUtil.getEname(token));
                refresh=JwtUtil.createRefreshToken(JwtUtil.getEid(refresh),JwtUtil.getEname(refresh));
                response.setHeader("token",token);
                response.setHeader("refresh",refresh);
                return true;
                }else{
                    log.info("token有效，token过期，验证refresh，refresh过期，拦截");
                    ResponseEntity responseEntity = new ResponseEntity(401,"error","token有效，token过期，验证refresh，refresh过期，拦截");
                    response.getWriter().write(new ObjectMapper().writeValueAsString(responseEntity));
                    return false;
                }
            }
        }
        log.info("token无效，拦截");
        ResponseEntity responseEntity = new ResponseEntity(401,"error","未登录");
        response.getWriter().write(new ObjectMapper().writeValueAsString(responseEntity));
        return false;
    }
}
