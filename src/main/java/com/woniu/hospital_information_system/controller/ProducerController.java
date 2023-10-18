package com.woniu.hospital_information_system.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @Autowired
    RabbitTemplate rabbitTemplate;
    public void sendEmail(String email) {
        rabbitTemplate.convertAndSend("","queuehelloworld",email);
    }
}
