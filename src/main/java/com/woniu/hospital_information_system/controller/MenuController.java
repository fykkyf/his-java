package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.DTO.MenuDTO;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    //根据是否存在菜单id判断添加或修改
    @PostMapping("/update")
    public ResponseEntity updateMenu(@RequestBody MenuDTO menuDTO){
        boolean exist = menuService.checkExist(menuDTO.getMenuId());
        if(exist){
            menuService.update(menuDTO);
            return new ResponseEntity(200,"success","修改成功");
        }else {
            menuService.add(menuDTO);
            return new ResponseEntity(200,"success","添加成功");
        }
    }
}
