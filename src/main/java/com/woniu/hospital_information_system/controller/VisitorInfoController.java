package com.woniu.hospital_information_system.controller;


import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.service.VisitorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 * 门诊患者信息
 * */
@RestController
@RequestMapping("visitorInfo")
public class VisitorInfoController {

    @Autowired
    VisitorInfoService visitorInfoService;
    @PostMapping("/add")
    //挂号时，向门诊患者信息表添加患者信息
    public ResponseEntity addVisitorInfo(VisitorInfo visitorInfo){
        visitorInfoService.addVisitorInfo(visitorInfo);
        return new ResponseEntity(200,"挂号成功",null);
    }

    @PostMapping("/getByVid")
    //通过门诊id，查询患者信息
    public ResponseEntity getVisitorInfoByVisitorId(Integer visitorId){
        VisitorInfo visitorInfoByVisitorId = visitorInfoService.getVisitorInfoByVisitorId(visitorId);
        return new ResponseEntity(200,"查询成功",visitorInfoByVisitorId);
    }
}
