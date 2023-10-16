package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @RequestMapping("/givemenu")
    public ResponseEntity giveMenu(){

        roleService.giveMenu();
        return new ResponseEntity(200,"","");
    }

}
