package com.woniu.hospital_information_system.controller;


import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.mapper.VisitorBillMapper;
import com.woniu.hospital_information_system.service.VisitorBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
