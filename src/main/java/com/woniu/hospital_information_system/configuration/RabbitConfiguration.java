package com.woniu.hospital_information_system.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Bean
    public Queue queuehelloworld(){
        return new Queue("queuehelloworld");
    }
}
