package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.VisitorBill;
import com.woniu.hospital_information_system.mapper.VisitorBillMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class VisitorBillServiceImplTest {
    @Autowired
    VisitorBillMapper visitorBillMapper;

    @Test
    void changeAllStatus() {
    }
}