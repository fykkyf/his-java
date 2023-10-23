package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.DTO.ClinicLabDTO;
import com.woniu.hospital_information_system.entity.DTO.TreatmentDTO;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.service.ClinicLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/clinicLab")
public class ClinicLabController {
    @Autowired
    ClinicLabService clinicLabService;

    //查询
    @PostMapping("/getAllClinicLab")
    public Object getAllClinicLab(@RequestBody ClinicLabDTO clinicLabDTO){
        return new ResponseEntity(200,"",clinicLabService.getAllClinicLab(clinicLabDTO));
    }

    //上传检验结果
    @PostMapping("/updateAllClinicLab")
    @Transactional
    public Object updateAllClinicLab(@RequestBody ClinicLabDTO clinicLabDTO){
        clinicLabService.updateVb(clinicLabDTO);
        clinicLabService.updateAllClinicLab(clinicLabDTO);
        return new ResponseEntity(200,"","上传完成");
    }
}
