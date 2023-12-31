package com.woniu.hospital_information_system.controller;


import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.VO.VisitorBillResultVO;
import com.woniu.hospital_information_system.entity.VisitorBill;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.mapper.VisitorBillMapper;
import com.woniu.hospital_information_system.service.VisitorBillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j
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
        Integer treatmentId = visitorBillMapper.getTreatmentId(visitorInfo.getEmployee().getEmployeeId());



        return new ResponseEntity(200,"ok",visitorBillService.getPriceByTreatmentId(treatmentId));
    }


    @PostMapping("/updatePayStatus")
    public ResponseEntity updatePayStatus(@RequestBody VisitorInfo visitorInfo){
        visitorBillService.updatePayStatus(visitorInfo.getVisitorId());
        return new ResponseEntity(200,"修改成功",null);
    }

    //根据门诊信息表查询病人费用表
    @GetMapping("/getBillByVisitorId/{visitorId}")
    public ResponseEntity getBillByVisitorId(@PathVariable Integer visitorId){
        VisitorBillResultVO visitorBillResultVO = visitorBillService.getVisitorBillVO(visitorId);
        if (visitorBillResultVO != null){
            log.info(visitorBillResultVO.toString());
            return new ResponseEntity(200,"success",visitorBillResultVO);
        }
        else {
            log.info("no data found");
            return new ResponseEntity(444,"success","No information Found");
        }

    }
    @GetMapping("/getRefundByVisitorId/{visitorId}")
    public ResponseEntity getRefundByVisitorId(@PathVariable Integer visitorId){
        VisitorBillResultVO visitorBillResultVO = visitorBillService.getRefundBillVO(visitorId);

        return new ResponseEntity(200,"success",visitorBillResultVO);
    }

    //根据病人费用表id退款
    @PostMapping("/changePaymentStatus/{visitorBillId}")
    public ResponseEntity changePaymentStatus(@PathVariable Integer visitorBillId){
        visitorBillService.refundPayment(visitorBillId);
        return new ResponseEntity(200,"success","退款成功");
    }

    @PostMapping("/changeAllStatus/{visitorId}")
    public ResponseEntity changeAllStatus(@PathVariable Integer visitorId){
        visitorBillService.changeAllStatus(visitorId);
        return new ResponseEntity(200,"success","支付成功");
    }

    @PostMapping("/updateManipulateStatus")
    public ResponseEntity updateManipulateStatus(@RequestBody VisitorBill visitorBill){
        visitorBillService.updateManipulateStatus(visitorBill);
        return new ResponseEntity(200,"ok",null);
    }
}
