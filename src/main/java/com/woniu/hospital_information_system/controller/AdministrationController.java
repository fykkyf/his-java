package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.Administration;
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

    @GetMapping("/getAll")
    /*
    *   获取所有用法信息
    **/
    public ResponseEntity getAllAdministrations(){
        return new ResponseEntity(200,"查询成功",administrationService.getAllAdministrations());
    }
    @PostMapping("/update")
    public ResponseEntity updateAdministration(@RequestBody Administration administration){
        if (administration.getAdministrationId()==null){
            administrationService.addAdministration(administration);
            return new ResponseEntity(200,"添加成功",null);
        }else {
            administrationService.updateAdministration(administration);
            return new ResponseEntity(200,"修改成功",null);
        }

    }
    @RequestMapping("/remove/{administrationId}")
    public ResponseEntity removeAdministration(@PathVariable int administrationId){
        administrationService.removeAdministration(administrationId);
        return new ResponseEntity(200,"success",null);
    }



}
