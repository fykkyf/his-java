package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.RegularResult;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.service.RegularResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("regular")
public class RegularResultController {
    @Autowired
    RegularResultService regularResultService;
    /*
    *   根据patientId查询三测信息
    * */
    @GetMapping("/getById/{patientId}")
    public Object getRegularByPatientId(@PathVariable("patientId") Integer patientId) {
        return new ResponseEntity(200,"request success",regularResultService.getRegularByPatientId(patientId));
    }
}
