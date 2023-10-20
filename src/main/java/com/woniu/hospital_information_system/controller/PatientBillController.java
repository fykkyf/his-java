package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.VO.PatientBillResultVO;
import com.woniu.hospital_information_system.entity.VO.PatientBillVO;
import com.woniu.hospital_information_system.service.PatientBillService;
import com.woniu.hospital_information_system.service.PatientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patientBill")
public class PatientBillController {
    @Autowired
    PatientBillService patientBillService;
    @Autowired
    PatientInfoService patientInfoService;

    //查询结算结算账单
    @GetMapping("/getPatientBill/{patientId}")
    public ResponseEntity getPatientBillByPatientId(@PathVariable Integer patientId){

        PatientBillResultVO patientBillResultVO = patientBillService.getPatientBillVO(patientId);

        return new ResponseEntity(200,"success",patientBillResultVO);
    }

    //修改支付状态
    @PostMapping("/billPaymentStatus")
    public ResponseEntity billPaymentStatus(Integer patientBillId){
        patientBillService.billPaymentStatus(patientBillId);

        return new ResponseEntity(200,"success","修改成功");
    }


    @PostMapping("/chengeAllPaymentStatus")
    public ResponseEntity chengeAllPaymentStatus(PatientInfoDTO patientInfoDTO) {
        List<Integer> list = patientBillService.getAllBillIds(patientInfoDTO.getPatientId());
        for (int i=0; i <list.size();i++){
            patientBillService.billPaymentStatus(list.get(i));
        }

        return new ResponseEntity(200, "success", "修改成功");
    }
}
