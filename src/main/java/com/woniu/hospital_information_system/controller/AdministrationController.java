package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.Employee;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.Unit;
import com.woniu.hospital_information_system.service.AdministrationService;
import com.woniu.hospital_information_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("administration")
public class AdministrationController {
    @Autowired
    AdministrationService administrationService;

    @GetMapping("/get/all")
    /*
    *   获取所有用法信息
    **/
    public ResponseEntity getAllAdministrations(){
        return new ResponseEntity(200,"查询成功",administrationService.getAllAdministrations());
    }


}
