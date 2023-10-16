package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RoleServiceImplTest {
    @Autowired
    RoleService roleService;
    @Test
    public void testRoleService01(){
        roleService.giveMenu();
    }
}