package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.DTO.RoleMenuDTO;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.Role;
import com.woniu.hospital_information_system.entity.Unit;
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
        return new ResponseEntity(200,"success","Success");
    }
    @RequestMapping("/removeRole/{roleId}")
    public ResponseEntity removeRoleByRoleId(@PathVariable int roleId){
        roleService.removeRoleByRoleId(roleId);
        return new ResponseEntity(200,"success","Success");
    }
    @PostMapping("/updateRole")
    public ResponseEntity updateRole(@RequestBody Role role){
        if (role.getRoleId()==null){
            roleService.add(role);
            return new ResponseEntity(200,"Create new role success",null);
        }else {
            roleService.update(role);
            return new ResponseEntity(200,"Edit Success",null);
        }

    }
    //添加新职位
    @PostMapping("/add")
    public ResponseEntity addRole(@RequestBody Role role){
        roleService.add(role);
        return new ResponseEntity(200,"success","Success");
    }
    //通过职位id获取拥有的菜单权限
    @RequestMapping("/getMenuIds/{roleId}")
    public ResponseEntity selectMenuIdsByRoleId(@PathVariable("roleId") int roleId){
        return new ResponseEntity(200,"",roleService.selectMenuIdsByRoleId(roleId));
    }
}
