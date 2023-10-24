package com.woniu.hospital_information_system.controller;


import com.woniu.hospital_information_system.entity.ClinicOrder;
import com.woniu.hospital_information_system.entity.DTO.ClinicOrderDTO;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.VO.ClinicOrderVO;
import com.woniu.hospital_information_system.service.impl.ClinicOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("clinicOrder")
public class ClinicOrderController {

    @Autowired
    ClinicOrderServiceImpl clinicOrderService;


    @PostMapping("/addClinicOrder")
    //添加门诊医嘱,生成费用，争对药品和非药品，检查和检验要在检查表和检验表中新增数据
    public ResponseEntity addClinicOrder(@RequestBody ClinicOrderDTO clinicOrderDTO){
        clinicOrderService.addClinicOrder(clinicOrderDTO);
        return new ResponseEntity(200,"ok",null);
    }

    @PostMapping("/getOrderByVisitorId")
    public ResponseEntity getOrderByVisitorId(Integer visitorId){
        List<ClinicOrderVO> clinicOrderDTOList = clinicOrderService.getOrderByVisitorId(visitorId);
        return new ResponseEntity(200,"ok",clinicOrderDTOList);
    }
}
