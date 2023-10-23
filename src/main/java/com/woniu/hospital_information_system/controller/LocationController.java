package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.service.AdministrationService;
import com.woniu.hospital_information_system.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("location")
public class LocationController {
    @Autowired
    LocationService locationService;
    @GetMapping("emptyLocation")
    public ResponseEntity emptyLocation(){
        return new ResponseEntity(200,"success",locationService.getLocationByStatus(0));
    }

    @GetMapping("/get/all")
    /*
    *   获取所有床位信息
    **/
    public ResponseEntity getAllLocations(){
        return new ResponseEntity(200,"查询成功",locationService.getAllLocation());
    }

    @GetMapping("/get/allNoBind")
    /*
     *   获取所有床位信息
     **/
    public ResponseEntity getLocationsByNoBind(){
        return new ResponseEntity(200,"查询成功",locationService.getLocationByStatus(1));
    }


}
