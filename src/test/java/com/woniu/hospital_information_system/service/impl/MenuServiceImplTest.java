package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.controller.MenuController;
import com.woniu.hospital_information_system.entity.Menu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MenuServiceImplTest {
    @Autowired
    MenuServiceImpl menuService;
    @Autowired
    MenuController menuController;
    @Test
    public void testMenuService01(){
       List<Menu> menus =  menuService.getAllMenus();
        System.out.println(menus);
    }
    @Test
    public void testDeleteMenu(){
        menuService.removeByMenuId(1);
    }
}