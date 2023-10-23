package com.woniu.hospital_information_system.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class VisitorInfoMapperTest {
    @Autowired
    VisitorInfoMapper visitorInfoMapper;

    @Test
    void selectVisitorInfoByIdNumber() {
        System.out.println(visitorInfoMapper.selectVisitorInfoByIdNumber("223456789"));
    }
}