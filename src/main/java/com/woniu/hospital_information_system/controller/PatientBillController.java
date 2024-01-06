package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.PatientBill;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.VO.PatientBillResultVO;
import com.woniu.hospital_information_system.entity.VO.PatientBillVO;
import com.woniu.hospital_information_system.service.PatientBillService;
import com.woniu.hospital_information_system.service.PatientInfoService;
import com.woniu.hospital_information_system.service.PatientOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("patientBill")
public class PatientBillController {
    @Autowired
    PatientBillService patientBillService;
    @Autowired
    PatientInfoService patientInfoService;
    @Autowired
    PatientOrderService patientOrderService;

    //查询结算结算账单
    @GetMapping("/getPatientBill/{patientId}")
    public ResponseEntity getPatientBillByPatientId(@PathVariable Integer patientId){

        PatientBillResultVO patientBillResultVO = patientBillService.getPatientBillVO(patientId);
        if(patientBillResultVO != null){
            log.info(patientBillResultVO.toString());
            return new ResponseEntity(200,"success",patientBillResultVO);
        }
        else {
            log.info("no data found");
            return new ResponseEntity(444,"success","No information Found");
        }

    }

    //修改支付状态
    @Transactional
    @PostMapping("/chengeAllPaymentStatus/{patientId}")
    public ResponseEntity chengeAllPaymentStatus(@PathVariable Integer patientId) {
        //查询所有费用单id
        List<Integer> list = patientBillService.getAllBillIds(patientId);
        for (int i=0; i <list.size();i++){
            //更改费用表支付状态
            patientBillService.billPaymentStatus(list.get(i));
        }
        //更改信息表支付状态
        patientInfoService.finishPayment(patientId);
        //更改医嘱表执行状态
        patientOrderService.finishPayment(patientId);
        return new ResponseEntity(200, "success", "修改成功");
    }

    /*
    * 修改完成状态
    * */
    @PostMapping("/modifyManipulateStatus")
    public Object modifyManipulateStatus(@RequestBody PatientBill patientBill) {
        patientBillService.modifyManipulateStatusByBillId(patientBill.getPatientBillId());
        return new ResponseEntity(200,"request success",null);
    }
}
