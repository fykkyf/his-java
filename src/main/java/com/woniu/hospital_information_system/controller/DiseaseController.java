package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.service.DiseaseService;
import com.woniu.hospital_information_system.service.DosageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("disease")
public class DiseaseController {
    @Autowired
    DiseaseService diseaseService;

    @GetMapping("/get/all")
    /*
    *   获取所有疾病信息
    **/
    public ResponseEntity getAllDiseases(){
        return new ResponseEntity(200,"查询成功",diseaseService.getAllDiseases());
    }


}
