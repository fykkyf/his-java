package com.woniu.hospital_information_system.controller;


import com.woniu.hospital_information_system.entity.ClinicOrder;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.service.impl.ClinicOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clinicOrder")
public class ClinicOrderController {

    @Autowired
    ClinicOrderServiceImpl clinicOrderService;


    @PostMapping("/addClinicOrder")
    //添加门诊医嘱,生成费用，争对药品和非药品，检查和检验要在检查表和检验表中新增数据
    public ResponseEntity addClinicOrder(@RequestBody ClinicOrder clinicOrder){
        clinicOrderService.addClinicOrder(clinicOrder);
        return new ResponseEntity(200,"ok",null);
    }
}
