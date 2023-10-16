package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.service.PatientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("patientInfo")
public class PatientInfoController {
    @Autowired
    PatientInfoService patientInfoService;
    /*
    * 查询所有住院患者信息
    * */
    @GetMapping("/get")
    public Object getAllPatientInfo() {
        patientInfoService.getAllPatientInfo();
        return new ResponseEntity(200,"request success",null);
    }
}