package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.Treatment;
import com.woniu.hospital_information_system.entity.TreatmentDTO;
import com.woniu.hospital_information_system.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/treatment")
public class TreatmentController {
    @Autowired
    TreatmentService treatmentService;
    @PostMapping("/selectAllTreatment")
    public Object selectAllTreatment(@RequestBody  TreatmentDTO treatmentDTO){
        return new ResponseEntity(200,"",treatmentService.selectAllTreatment(treatmentDTO));
    }

}
