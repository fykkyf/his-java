package com.woniu.hospital_information_system.controller;

import com.github.pagehelper.PageInfo;
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
    @PostMapping("/get/all")
    public Object getAllPatientOrder(@RequestBody PatientOrderDTO patientOrderDTO) {
        return new ResponseEntity(200,"request success",patientOrderService.getAllPatientOrders(patientOrderDTO.getPageNum(),patientOrderDTO.getPageSize()));
    }
    /*
     * 查询所有住院患者医嘱信息
     * */
    @PostMapping("/get/daily")
    public Object getAllPatientOrdersByDaily(@RequestBody PatientOrderDTO patientOrderDTO) {
        return new ResponseEntity(200,"request success",patientOrderService.getAllPatientOrdersByDaily(patientOrderDTO.getPageNum(),patientOrderDTO.getPageSize(),patientOrderDTO.getPatient().getPatientId()));
    }
    /*
     *   模糊查询患者医嘱信息
     * */
    @PostMapping("/getByKeyWord")
    public Object getPatientInfoByKeyWord(@RequestBody PatientOrderDTO patientOrderDTO) {
        return new ResponseEntity(200,"request success",new PageInfo<>(patientOrderService.getPatientOrderByKeyWord(patientOrderDTO)));
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
//        System.out.println(patientOrderDTO);
        patientOrderService.addPatientOrder(patientOrderDTO);

        return new ResponseEntity(200,"request success",null);
    }
    //办理出院--修改费用表信息
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

    /*
    *   医生修改病人医嘱
    * */
    @PostMapping("/modify")
    public Object modifyPatientOrder(@RequestBody PatientOrderDTO patientOrderDTO) {
        patientOrderService.modifyPatientOrder(patientOrderDTO);
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
