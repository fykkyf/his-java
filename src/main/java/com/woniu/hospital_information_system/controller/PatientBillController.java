package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.VO.PatientBillVO;
import com.woniu.hospital_information_system.service.PatientBillService;
import com.woniu.hospital_information_system.service.PatientInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("patientBill")
public class PatientBillController {
    @Autowired
    PatientBillService patientBillService;
    @Autowired
    PatientInfoService patientInfoService;
    //查询结算结算账单
    @GetMapping("/getPatientBill")
    public ResponseEntity getPatientBillByPatientId(Integer patientId){
        //根据patientId查询是否有医保
        int insuranceStatus = patientInfoService.getPatientInfoByPatientId(patientId).getInsuranceStatus();

        List<PatientBillVO> patientBillVOList = patientBillService.getPatientBillVO(patientId,insuranceStatus);


        return new ResponseEntity(200,"success","");
    }
    //根据医保修改账单费用

    //修改支付状态
    @PostMapping("/billPaymentStatus")
    public ResponseEntity billPaymentStatus(Integer patientBillId){


        return new ResponseEntity(200,"success","修改成功");
    }
}
