package com.woniu.hospital_information_system.controller;


import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.service.VisitorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
 * 门诊患者信息
 * */
@RestController
@RequestMapping("visitorInfo")
public class VisitorInfoController {

    @Autowired
    VisitorInfoService visitorInfoService;
    @PostMapping("/add")
    //挂号时，向门诊患者信息表添加患者信息,且在门诊患者费用表中生成数据
    public ResponseEntity addVisitorInfo(@RequestBody VisitorInfo visitorInfo){
        visitorInfoService.addVisitorInfo(visitorInfo);
        return new ResponseEntity(200,"挂号成功",null);
    }

    @PostMapping("/getByVid")
    //通过门诊id，查询患者信息
    public ResponseEntity getVisitorInfoByVisitorId(Integer visitorId){
        VisitorInfo visitorInfoByVisitorId = visitorInfoService.getVisitorInfoByVisitorId(visitorId);
        return new ResponseEntity(200,"查询成功",visitorInfoByVisitorId);
    }

    @GetMapping("/getVisitorInfoByPaySuccess")
    //通过已支付的状态查询，挂号的患者
    public ResponseEntity getVisitorInfoByPaySuccess(){
        List<VisitorInfo> visitorInfoByPaySuccess=visitorInfoService.getVisitorInfoByPaySuccess();
        return new ResponseEntity(200,"查询成功",visitorInfoByPaySuccess);
    }

    @GetMapping("/updateClinicStatus")
    //在医生那里去看病时，修改病人的状态码为就诊[2]
    public ResponseEntity updateClinicStatus(Integer visitorId){
        visitorInfoService.updateClinicStatus(visitorId);
        return new ResponseEntity(200,"ok",null);
    }

    @PostMapping("/getVisitingByVisitorId")
    //获得正在看病的信息
    public ResponseEntity getVisitingByVisitorId(Integer visitorId){
        VisitorInfo visitingByVisitorId = visitorInfoService.getVisitingByVisitorId(visitorId);
        return new ResponseEntity(200,"ok",visitingByVisitorId);
    }

    @PostMapping("/updateClinicStatusAfterVisiting")
    //下完医嘱，修改状态为过诊且给病人添加疾病
    public ResponseEntity updateClinicStatusAfterVisiting(@RequestBody VisitorInfo visitorInfo){
        visitorInfoService.updateClinicStatusAfterVisiting(visitorInfo);
        return new ResponseEntity(200,"ok",null);
    }

    @PostMapping("/updateDisease")
    //下完医嘱，修改状态为过诊且给病人添加疾病
    public ResponseEntity updateDisease(@RequestBody VisitorInfo visitorInfo){
        visitorInfoService.updateDisease(visitorInfo);
        return new ResponseEntity(200,"ok",null);
    }
}
