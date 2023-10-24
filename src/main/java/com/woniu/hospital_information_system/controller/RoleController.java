package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.DTO.RoleMenuDTO;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.Role;
import com.woniu.hospital_information_system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    //给指定职位添加或修改菜单权限
    @RequestMapping("/giveMenu")
    public ResponseEntity giveMenu(@RequestBody RoleMenuDTO roleMenuDTO){

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
    //添加新职位
    @PostMapping("/add")
    public ResponseEntity addRole(@RequestBody Role role){
        roleService.add(role);
        return new ResponseEntity(200,"success","添加成功");
    }
    //通过职位id获取拥有的菜单权限
    @RequestMapping("/getMenuIds/{roleId}")
    public ResponseEntity selectMenuIdsByRoleId(@PathVariable("roleId") int roleId){
        return new ResponseEntity(200,"",roleService.selectMenuIdsByRoleId(roleId));
    }
}
