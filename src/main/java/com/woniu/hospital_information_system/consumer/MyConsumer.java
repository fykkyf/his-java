package com.woniu.hospital_information_system.consumer;

import cn.hutool.extra.mail.MailUtil;
import com.rabbitmq.client.Channel;
import com.woniu.hospital_information_system.controller.VerifyCodeController;
import com.woniu.hospital_information_system.util.RedisUtil;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
//public class MyConsumer {
//
//    @Autowired
//    RedisUtil redisUtil;
//
//    //这个注解就是让这个方法监听指定的队列，接收消息，处理消息
//    @RabbitListener(queues="queuehelloworld")
//    public void receiveQueuehelloworld(String email, Message message, Channel channel) throws IOException {
//        // 生成随机验证码
//        String verificationCode = VerifyCodeController.generateCode(6);
//        //验证码存储到redis
//        redisUtil.set(email, verificationCode, 300); // 设置过期时间为5分钟
//        //发送邮箱
//        MailUtil.send(email, "重置密码验证码", "您的验证码为：" + verificationCode + "(有效时间为5分钟)",false);
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
//    }
//}
