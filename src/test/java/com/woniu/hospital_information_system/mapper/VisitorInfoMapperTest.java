package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.controller.VisitorInfoController;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.service.VisitorInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class VisitorInfoMapperTest {
    @Autowired
    VisitorInfoMapper visitorInfoMapper;
    @Autowired
    VisitorInfoService visitorInfoController;
    @Test
    void test01(){
        List<VisitorInfo> all = visitorInfoController.getAll();
        System.out.println(all);
    }
}