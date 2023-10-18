package com.woniu.hospital_information_system;


import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan
@SpringBootApplication
public class HospitalInformationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalInformationSystemApplication.class, args);

    }

}
