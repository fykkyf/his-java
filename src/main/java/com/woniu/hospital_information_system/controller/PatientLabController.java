package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.DTO.ClinicLabDTO;
import com.woniu.hospital_information_system.entity.DTO.PatientLabDTO;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.service.PatientLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/patientLab")
public class PatientLabController {
    @Autowired
    PatientLabService patientLabService;
    //查询
    @PostMapping("/getAllPatientLab")
    public Object getAllPatientLab(@RequestBody PatientLabDTO patientLabDTO){
        return new ResponseEntity(200,"",patientLabService.getAllPatientLab(patientLabDTO));
    }

    //检验结果上传

    @PostMapping("/updateAllPatientLab")
    @Transactional
    public Object updateAllPatientLab(@RequestBody PatientLabDTO patientLabDTO){
        patientLabService.updateAllPatientLab(patientLabDTO);
        patientLabService.updatePb(patientLabDTO);
        return new ResponseEntity(200,"","上传成功！");
    }

}
