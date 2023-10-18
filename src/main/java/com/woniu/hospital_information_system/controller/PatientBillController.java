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

        return new ResponseEntity(200,"success",patientBillVOList);
    }

    //修改支付状态
    @PostMapping("/billPaymentStatus")
    public ResponseEntity billPaymentStatus(Integer patientBillId){
        patientBillService.billPaymentStatus(patientBillId);

        return new ResponseEntity(200,"success","修改成功");
    }
    //显示当前病人所有费用总和
    @GetMapping("/getPaymentSum")
    public ResponseEntity getPaymentSum(PatientInfoDTO patientInfoDTO){
        List<PatientBillVO> patientBillVOList = patientBillService.getPatientBillVO(patientInfoDTO.getPatientId(),patientInfoDTO.getInsuranceStatus());
        Double finalResult = patientBillService.getPaymentSum(patientBillVOList);
        return new ResponseEntity(200,"success",finalResult);
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
