package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;
    //查询所有菜单
    @RequestMapping("/getAll")
    public ResponseEntity getAllMenus(){
        return new ResponseEntity(200,"success",menuService.getAllMenus());
    }
    //根据菜单id删除菜单
    @RequestMapping("/remove/{menuId}")
    public ResponseEntity removeByMenuId(@PathVariable int menuId){
        menuService.removeByMenuId(menuId);
        return new ResponseEntity(200,"success","删除成功");
    }
}
