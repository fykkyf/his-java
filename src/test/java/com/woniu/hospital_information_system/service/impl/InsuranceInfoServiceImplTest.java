package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.InsuranceInfo;
import com.woniu.hospital_information_system.service.InsuranceInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class InsuranceInfoServiceImplTest {
    @Autowired
    InsuranceInfoService insuranceInfoService;

    @Test
    void getInsuranceInfoByIdNumber() {
        InsuranceInfo insuranceInfo = insuranceInfoService.getInsuranceInfoByIdNumber("0");
        System.out.println(insuranceInfo);
    }
}