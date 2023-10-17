package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.DTO.PatientOrderDTO;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.service.PatientInfoService;
import com.woniu.hospital_information_system.service.PatientOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patientOrder")
public class PatientOrderController {
    @Autowired
    PatientOrderService patientOrderService;
    /*
    * 查询所有住院患者医嘱信息
    * */
    @GetMapping("/get/all")
    public Object getAllPatientOrder() {
        return new ResponseEntity(200,"request success",patientOrderService.getAllPatientOrders());
    }

    /*
    *根据id查询患者医嘱信息
    * */
    @GetMapping("/getById/{patientId}")
    public Object getPatientOrderByPatientOrderId(@PathVariable("patientId") Integer patientId) {
        return new ResponseEntity(200,"request success",patientOrderService.getPatientOrderByPatientId(patientId));
    }

    /*
    * 添加住院患者医嘱信息
    * */
    @PostMapping("/add")
    public Object addPatientInfo(@RequestBody PatientOrderDTO patientOrderDTO) {
        patientOrderService.addPatientOrder(patientOrderDTO);
        return new ResponseEntity(200,"request success",null);
    }
    //办理出院
    @PostMapping("/discharge")
    public ResponseEntity discharge(@RequestBody PatientInfoDTO patientInfoDTO){
        patientOrderService.dischargePatient(patientInfoDTO);
        return new ResponseEntity(200,"success","办理成功");
    }
}
