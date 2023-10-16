package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.controller.MenuController;
import com.woniu.hospital_information_system.entity.DTO.MenuDTO;
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
    @Test
    public void testUpdate(){
        MenuDTO menuDTO1 = new MenuDTO(1,"门诊收费管理1",null,0);
        MenuDTO menuDTO2 = new MenuDTO(null,"门诊收费管理1",null,0);
        System.out.println(menuController.updateMenu(menuDTO1).getData());
        System.out.println(menuController.updateMenu(menuDTO2).getData());
    }
}