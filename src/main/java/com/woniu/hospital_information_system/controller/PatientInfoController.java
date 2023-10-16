package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.service.PatientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        return new ResponseEntity(200,"request success",patientInfoService.getAllPatientInfo());
    }

    /*
    * 添加住院患者信息
    * */
    @PostMapping("/post")
    public Object addPatientInfo() {
        patientInfoService.addPatientInfo(new PatientInfoDTO());
        return new ResponseEntity(200,"request success",new Object());
    }
}
