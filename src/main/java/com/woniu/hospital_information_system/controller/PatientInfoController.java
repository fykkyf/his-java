package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.service.PatientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patientInfo")
public class PatientInfoController {
    @Autowired
    PatientInfoService patientInfoService;
    /*
    * 查询所有住院患者信息
    * */
    @GetMapping("/get/all")
    public Object getAllPatientInfo() {
        return new ResponseEntity(200,"request success",patientInfoService.getAllPatientInfos());
    }

    /*
    *根据id查询患者信息
    * */
    @GetMapping("/getById/{patientId}")
    public Object getPatientInfoByPatientInfoId(@PathVariable("patientId") Integer patientId) {
        return new ResponseEntity(200,"request success",patientInfoService.getPatientInfoByPatientInfoId(patientId));
    }

    /*
    * 添加住院患者信息
    * */
    @PostMapping("/add")
    public Object addPatientInfo(@RequestBody PatientInfoDTO patientInfoDTO) {
        patientInfoService.addPatientInfo(patientInfoDTO);
        return new ResponseEntity(200,"request success",null);
    }
    /*
    * 给住院患者安排床位
    * */
    @PostMapping("/add/location")
    public Object modifyPatientInfoByPatientInfoId(@RequestBody PatientInfoDTO patientInfoDTO) {
        patientInfoService.modifyPatientInfoByPatientInfoId(patientInfoDTO.getPatientId(),patientInfoDTO.getLocationId());
        return new ResponseEntity(200,"request success",null);
    }
    //添加出院诊断
    @PostMapping("/dischargeDiagnosis")
    public ResponseEntity dischargeDiagnosis(@RequestBody PatientInfoDTO patientInfoDTO) {
        patientInfoService.dischargeDiagnosis(patientInfoDTO);
        return new ResponseEntity(200,"request success","添加成功");
    }

}
