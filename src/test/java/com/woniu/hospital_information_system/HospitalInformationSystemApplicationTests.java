package com.woniu.hospital_information_system;


import cn.hutool.core.date.DateTime;
import com.woniu.hospital_information_system.controller.VisitorInfoController;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static java.time.LocalTime.now;

@SpringBootTest
class HospitalInformationSystemApplicationTests {

    @Autowired
    VisitorInfoController visitorInfoController;

    @Test
    void contextLoads() {
//        VisitorInfo visitorInfo = new VisitorInfo(null,"卢子子",null,"26",1328152,1,1,null,null,null);
//        visitorInfoController.addVisitorInfo(visitorInfo);
    }

}
