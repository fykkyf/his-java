package com.woniu.hospital_information_system.controller;


import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.VisitorBill;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.mapper.VisitorBillMapper;
import com.woniu.hospital_information_system.service.VisitorBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("visitorBill")
public class VisitorBillController {
    @Autowired
    VisitorBillService visitorBillService;
    @Autowired
    VisitorBillMapper visitorBillMapper;


    @PostMapping("/getPrice")
    /*
    通过doctorId获取到treatmentId，再获取price
     */
    public ResponseEntity getPriceByTreatmentId(@RequestBody VisitorInfo visitorInfo){
        Integer treatmentId = visitorBillMapper.getTreatmentId(visitorInfo.getDoctorId());
        return new ResponseEntity(200,"ok",visitorBillService.getPriceByTreatmentId(treatmentId));
    }


    @PostMapping("/updatePayStatus")
    public ResponseEntity updatePayStatus(@RequestBody VisitorInfo visitorInfo){
        visitorBillService.updatePayStatus(visitorInfo.getVisitorId());
        return new ResponseEntity(200,"修改成功",null);
    }
    //根据门诊信息表查询病人费用表
    @GetMapping("/getBillByVisitorId")
    public ResponseEntity getBillByVisitorId(@RequestBody VisitorInfo visitorInfo){
        List<VisitorBill> visitorBills = visitorBillService.getAllBillsByVisitorId(visitorInfo.getVisitorId());

        return new ResponseEntity(200,"success",visitorBills);
    }
    //根据病人费用表id修改支付状态
    @PostMapping("/changePaymentStatus")
    public ResponseEntity changePaymentStatus(@RequestBody Integer visitorBillId){
        visitorBillService.changePaymentStatus(visitorBillId);
        return new ResponseEntity(200,"success","支付成功");
    }
    @GetMapping("/getAllpayment")
    public ResponseEntity getAllpayment(@RequestBody VisitorInfo visitorInfo){
        Double sum = visitorBillService.changeAllpayment(visitorInfo);
        return new ResponseEntity(200,"success",sum);
    }
    @PostMapping("/changeAllStatus")
    public ResponseEntity changeAllStatus(@RequestBody VisitorInfo visitorInfo){
        visitorBillService.changeAllStatus(visitorInfo.getVisitorId());
        return new ResponseEntity(200,"success","支付成功");
    }
}
