package com.woniu.hospital_information_system.controller;


import com.woniu.hospital_information_system.entity.DTO.VisitorInfoDTO;
import com.woniu.hospital_information_system.entity.Employee;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.VisitorBill;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.service.VisitorInfoService;
import com.woniu.hospital_information_system.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        System.out.println(visitorInfo);
            visitorInfoService.addVisitorInfo(visitorInfo);
//        visitorInfoService.addVisitorInfo(visitorInfo);
        return new ResponseEntity(200,"ok",null);
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
    public ResponseEntity updateDisease(Integer visitorId,Integer diseaseId){
        visitorInfoService.updateDisease(visitorId,diseaseId);
        return new ResponseEntity(200,"ok",null);
    }

//    @GetMapping("/getAll")
//    public ResponseEntity getAll(){
//        List<VisitorInfo> visitorInfos=visitorInfoService.getAll();
//        System.out.println(visitorInfos);
//        return new ResponseEntity(200,"ok",visitorInfos);
//    }

    @GetMapping("/getVisitorByEmployeeId")
    public ResponseEntity getVisitorByEmployeeId(HttpServletRequest request){
        String token = request.getHeader("token");
        Integer eid = Integer.valueOf(JwtUtil.getEid(token));
        List<VisitorInfo> visitorInfos=visitorInfoService.getVisitorByEmployeeId(eid);
        System.out.println(visitorInfos);
        return new ResponseEntity(200,"ok",visitorInfos);
    }

    @PostMapping("/getVisitorInfoIdByPaySuccessAndManipulateStatus")
    public ResponseEntity getVisitorInfoIdByPaySuccessAndManipulateStatus(){
        List<VisitorInfoDTO> visitorInfo=visitorInfoService.getVisitorInfoIdByPaySuccessAndManipulateStatus();
        System.out.println("这里是"+visitorInfo);
        return new ResponseEntity(200,"",visitorInfo);
    }

    @PostMapping("/getByCondition")
    public ResponseEntity getByCondition(@RequestBody VisitorInfo visitorInfo){
        List<VisitorInfo> visitorInfos=visitorInfoService.getByCondition(visitorInfo);
        return new ResponseEntity(200,"",visitorInfos);
    }

    @PostMapping("/updateDoc")
    public ResponseEntity updateDoc(Integer visitorId,Integer employeeId,Integer unitId){
        visitorInfoService.updateDoc(visitorId,employeeId,unitId);
        System.out.println("visitorId:"+visitorId);
        System.out.println("employeeId:"+employeeId);
        System.out.println("unitId:"+unitId);
        return new ResponseEntity(200,"","修改成功");
    }


    @PostMapping("/getVisitorByIdAndCondition")
    public ResponseEntity getVisitorByIdAndCondition(@RequestBody VisitorInfo visitorInfo,HttpServletRequest request){
        String token = request.getHeader("token");
        Integer eid = Integer.valueOf(JwtUtil.getEid(token));
        Employee employee=new Employee();
        employee.setEmployeeId(eid);
        visitorInfo.setEmployee(employee);
        List<VisitorInfo> visitorInfos=visitorInfoService.getVisitorByIdAndCondition(visitorInfo);
        return new ResponseEntity(200,"",visitorInfos);
    }

    @PostMapping("/updateChecking")
    public ResponseEntity updateChecking(Integer visitorId){
        visitorInfoService.updateChecking(visitorId);
        return new ResponseEntity(200,"",null);
    }



    @GetMapping("/getCheckOver")
    //注意要通过医生的id去查
    public ResponseEntity getCheckOver(){
        List<VisitorInfo> visitorInfos = visitorInfoService.getCheckOver();
        return new ResponseEntity(200,"",visitorInfos);
    }

}
