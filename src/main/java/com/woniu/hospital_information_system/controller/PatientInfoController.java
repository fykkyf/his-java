package com.woniu.hospital_information_system.controller;

import com.github.pagehelper.PageInfo;
import com.woniu.hospital_information_system.entity.DTO.LocationDTO;
import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.VO.PatientBillResultVO;
import com.woniu.hospital_information_system.entity.VO.PatientInfoVO;
import com.woniu.hospital_information_system.service.LocationService;
import com.woniu.hospital_information_system.service.PatientInfoService;
import com.woniu.hospital_information_system.service.VisitorInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("patientInfo")
public class PatientInfoController {
    @Autowired
    PatientInfoService patientInfoService;
    @Autowired
    VisitorInfoService visitorInfoService;
    @Autowired
    LocationService locationService;
    /*
    * 查询所有住院患者信息
    * */
    @PostMapping("/get/all")
    public Object getAllPatientInfo(@RequestBody PatientInfoDTO patientInfoDTO) {
        return new ResponseEntity(200,"request success",patientInfoService.getAllPatientInfos(patientInfoDTO.getPageNum(),patientInfoDTO.getPageSize()));
    }
    @Transactional
    @PostMapping("/addLocation")
    public Object addLoaction(@RequestBody LocationDTO location){
        patientInfoService.addLocationId(location.getLocationId(),location.getPatientId());
        locationService.modifyLocationStatusByLocationId(location.getLocationId());
        return new ResponseEntity(200,"success","添加成功");
    }
    /*
    *根据患者id查询患者信息
    * */
    @GetMapping("/getById/{patientId}")
    public Object getPatientInfoByPatientInfoId(@PathVariable("patientId") Integer patientId) {
        return new ResponseEntity(200,"request success",patientInfoService.getPatientInfoByPatientId(patientId));
    }
    /*
     * 查询所有住院患者信息---添加床位
     * */
    @PostMapping("/get/allNoLocation")
    public Object getAllNoLocationPatientInfo(@RequestBody PatientInfoDTO patientInfoDTO) {
        return new ResponseEntity(200,"request success",patientInfoService.getAllPatientInfosByNoLocation(patientInfoDTO.getPageNum(),patientInfoDTO.getPageSize()));
    }
    /*
     * 查询所有住院患者信息---出院办理
     * */
    @PostMapping("/get/allDischarge")
    public Object getAllDischarge(@RequestBody PatientInfoDTO patientInfoDTO) {
        return new ResponseEntity(200,"request success",patientInfoService.getAllDischarge(patientInfoDTO.getPageNum(),patientInfoDTO.getPageSize()));
    }
    @GetMapping("/getPatientInfoByLocation")
    public Object getPatientInfoByLocation() {
        return new ResponseEntity(200,"request success",patientInfoService.getPatientInfoByLocation());
    }
    /*
    *   模糊查询患者信息
    * */
    @PostMapping("/getByKeyWord")
    public Object getPatientInfoByKeyWord(@RequestBody PatientInfoDTO patientInfoDTO) {
        return new ResponseEntity(200,"request success",new PageInfo<>(patientInfoService.getPatientInfoByKeyWord(patientInfoDTO)));
    }
    /*
     *   模糊查询患者信息--未安排床位
     * */
    @PostMapping("/getNoLocationByKeyWord")
    public Object getPatientInfoByNoLocation(@RequestBody PatientInfoDTO patientInfoDTO) {
        return new ResponseEntity(200,"request success",new PageInfo<>(patientInfoService.getPatientInfosByNoLocation(patientInfoDTO)));
    }

    /*
    * 添加住院患者信息
    * */
    @PostMapping("/add")
    public Object addPatientInfo(@RequestBody PatientInfoDTO patientInfoDTO) {
        patientInfoService.addPatientInfo(patientInfoDTO);
        return new ResponseEntity(200,"request success","添加成功");
    }
    /*
    * 给住院患者安排床位
    * */
    @PostMapping("/add/location")
    public Object modifyPatientInfoByPatientInfoId(@RequestBody PatientInfoDTO patientInfoDTO) {
        patientInfoService.modifyPatientInfoByPatientId(patientInfoDTO.getPatientId(),patientInfoDTO.getLocationId());
        return new ResponseEntity(200,"request success","添加成功");
    }
    /*
     * 添加入院诊断
     * */
    @PostMapping("/admissionDiagnosis")
    public Object admissionDiagnosis(@RequestBody PatientInfoDTO patientInfoDTO) {
        patientInfoService.admissionDiagnosis(patientInfoDTO);
        return new ResponseEntity(200,"request success","添加成功");
    }
    //添加出院诊断
    @PostMapping("/dischargeDiagnosis")
    public ResponseEntity dischargeDiagnosis(@RequestBody PatientInfoDTO patientInfoDTO) {
        patientInfoService.dischargeDiagnosis(patientInfoDTO);
        return new ResponseEntity(200,"request success","添加成功");
    }
    //办理出院
    @PostMapping("/completeDischarge")
    public ResponseEntity completeDischarge(@RequestBody PatientInfoDTO patientInfoDTO) {
        patientInfoService.completeDischarge(patientInfoDTO);
        return new ResponseEntity(200,"request success","办理成功");
    }

    /*
    * 修改住院患者信息表
    * 转科
    * */
    @PostMapping("/modify")
    public Object modifyPatientInfo(@RequestBody PatientInfoDTO patientInfoDTO) {
        patientInfoService.modifyPatientInfo(patientInfoDTO);
        return new ResponseEntity(200,"request success",null);
    }

    /*
    * 获取病人门诊信息
    * */
    @PostMapping("/get/visitorInfo")
    public Object getVisitorInfoByIdNumber(@RequestBody PatientInfoDTO patientInfoDTO) {
        return new ResponseEntity(200,"request success",patientInfoService.getVisitorInfoByIdNumber(patientInfoDTO.getIdNumber()));
    }

    /*
    * 根据门诊id查询门诊诊断
    * */
    @GetMapping("/get/clinicDiagnosis/{visitorId}")
    public Object getClinicDiagnosisByVisitorId(@PathVariable("visitorId") Integer visitorId) {
        return new ResponseEntity(200,"request success",visitorInfoService.getDiagnosisByVisitorId(visitorId));
    }
    @GetMapping("/getPatientInfoByPatientIdAndLocation/{patientId}")
    public ResponseEntity getPatientInfoByPatientIdAndLocation(@PathVariable Integer patientId){

        List<PatientInfo> patientInfoList = patientInfoService.getPatientInfoByPatientIdAndLocation(patientId);

        return new ResponseEntity(200,"success",patientInfoList);
    }

}
