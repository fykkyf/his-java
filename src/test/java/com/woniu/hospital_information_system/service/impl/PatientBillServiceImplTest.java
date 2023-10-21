package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.VO.PatientBillVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PatientBillServiceImplTest {
    @Autowired
    PatientBillServiceImpl patientBillService;

    @Test
    void test02(){
        patientBillService.billPaymentStatus(1);
    }

    @Test
    void test04(){
        List<Integer> list =patientBillService.getAllBillIds(1);
        System.out.println(list);

    }
    @Test
    void test05(){
        int[] list = new int[]{1, 2, 3, 5, 8};
        for (int i=0;i<list.length;i++){
            patientBillService.billPaymentStatus(list[i]);
        }

    }

}