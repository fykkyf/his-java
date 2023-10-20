package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.service.AdministrationService;
import com.woniu.hospital_information_system.service.DosageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dosage")
public class DosageController {
    @Autowired
    DosageService dosageService;

    @GetMapping("/get/all")
    /*
    *   获取所有用法信息
    **/
    public ResponseEntity getAllDosages(){
        return new ResponseEntity(200,"查询成功",dosageService.getAllDosages());
    }


}
