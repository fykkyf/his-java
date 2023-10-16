package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.DTO.RoleMenuDTO;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @RequestMapping("/givemenu")
    public ResponseEntity giveMenu(RoleMenuDTO roleMenuDTO){

        roleService.giveMenu(roleMenuDTO);
        return new ResponseEntity(200,"","");
    }
    //查询所有职位
    @RequestMapping("/getAll")
    public ResponseEntity getAllRoles(){
        return new ResponseEntity(200,"success",roleService.getAllRoles());
    }
    //根据角色id删除职位
    @RequestMapping("/remove/{roleId}")
    public ResponseEntity removeByRoleId(@PathVariable int roleId){
        roleService.removeByRoleId(roleId);
        return new ResponseEntity(200,"success","删除成功");
    }
}
