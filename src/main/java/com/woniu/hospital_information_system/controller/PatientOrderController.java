package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.DTO.PatientOrderDTO;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.service.LocationService;
import com.woniu.hospital_information_system.service.PatientInfoService;
import com.woniu.hospital_information_system.service.PatientOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patientOrder")
public class PatientOrderController {
    @Autowired
    PatientOrderService patientOrderService;
    @Autowired
    LocationService locationService;
    @Autowired
    PatientInfoService patientInfoService;
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
    /*
    * 护士审核医嘱
    * */
    @PostMapping("/checkDischarge")
    public ResponseEntity checkDischarge(@RequestBody PatientOrderDTO patientOrderDTO){
        patientOrderService.modifyPatientOrderByPatientId(patientOrderDTO);
        return new ResponseEntity(200,"request success",null);
    }

    //护士审核出院医嘱
//    @PostMapping("/checkDischarge")
//    public ResponseEntity checkDischarge(@RequestBody Integer status, PatientInfoDTO patientInfoDTO){
//        patientOrderService.checkDischarge(status,patientInfoDTO.getPatientId());
//        if(status==2){
//            locationService.updateLocationStatusEmpty(patientInfoDTO.getLocationId());
//            patientInfoService.updateLocationId(patientInfoDTO.getPatientId());
//            return new ResponseEntity(200,"success","办理成功");
//        }else {
//            return new ResponseEntity(200,"success","驳回成功");
//
//        }
//    }
}
