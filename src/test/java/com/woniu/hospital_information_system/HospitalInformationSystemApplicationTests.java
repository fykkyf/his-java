package com.woniu.hospital_information_system;


import com.woniu.hospital_information_system.controller.ClinicOrderController;
import com.woniu.hospital_information_system.controller.ClinicRaidologyController;
import com.woniu.hospital_information_system.controller.VisitorInfoController;
import com.woniu.hospital_information_system.entity.ClinicOrder;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.service.ClinicOrderService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static java.time.LocalTime.now;

@SpringBootTest
class HospitalInformationSystemApplicationTests {

    @Autowired
    VisitorInfoController visitorInfoController;
    @Autowired
    ClinicOrderController clinicOrderController;
    @Autowired
    ClinicOrderService clinicOrderService;


    @Autowired
    ClinicRaidologyController clinicRaidologyController;

    @Test
    void contextLoads() {
        VisitorInfo visitorInfo = new VisitorInfo(null,"卢子子",null,"26",1328152,1,1,null,null,null);
        visitorInfoController.addVisitorInfo(visitorInfo);
    }



    @Test
    void test1(){
        ClinicOrder clinicOrder = new ClinicOrder(null,3,3,3,"33",3,3,3,null,null);
        clinicOrderController.addClinicOrder(clinicOrder);
    }


    void test2(){


    }
}
