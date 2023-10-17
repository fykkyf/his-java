package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.controller.RoleController;
import com.woniu.hospital_information_system.entity.DTO.RoleMenuDTO;
import com.woniu.hospital_information_system.entity.Role;
import com.woniu.hospital_information_system.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class RoleServiceImplTest {
    @Autowired
    RoleService roleService;
    @Autowired
    RoleController roleController;
    @Test
    public void testRoleService01(){
        Integer[] arrayList = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        RoleMenuDTO roleMenuDTO = new RoleMenuDTO(new Role(10,null,0),arrayList);
        roleService.giveMenu(roleMenuDTO);
    }
    @Test
    public void testRoleService02(){

       List<Role> roles =  roleService.getAllRoles();
        System.out.println(roles);
    }
    @Test
    public void testRoleService03(){
        roleController.removeByRoleId(11);
    }
    @Test
    public void testRoleService04(){
        Role role = new Role(null,"清洁工",null);
        roleController.addRole(role);
    }
    @Test
    public void testRoleService05(){
       List<Integer> al =  roleService.selectMenuIdsByRoleId(1);
        System.out.println(al);
    }
}