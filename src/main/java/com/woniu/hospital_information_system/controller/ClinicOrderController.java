package com.woniu.hospital_information_system.controller;


import com.woniu.hospital_information_system.entity.ClinicOrder;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.service.ClinicOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clinicOrder")
public class ClinicOrderController {

    @Autowired
    ClinicOrderService clinicOrderService;

    @PostMapping("/addClinicOrder")
    //添加门诊医嘱
    public ResponseEntity addClinicOrder(@RequestBody ClinicOrder clinicOrder){
        clinicOrderService.addClinicOrder(clinicOrder);
        return new ResponseEntity(200,"ok",null);
    }

}
