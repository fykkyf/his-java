package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.Location;
import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.service.AdministrationService;
import com.woniu.hospital_information_system.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("location")
public class LocationController {
    @Autowired
    LocationService locationService;
    @GetMapping("emptyLocation")
    public ResponseEntity emptyLocation(){
        return new ResponseEntity(200,"success",locationService.getLocationByStatus(1));
    }

    @PostMapping("/updateLocation")
    public Object getVisitorInfoByIdNumber(@RequestBody Location location) {
        if(location.getLocationId()==null){
            locationService.addNewLocation(location);
            return new ResponseEntity(200,"request success","Success");
        }else {
            locationService.updateLocation(location);
            return new ResponseEntity(201,"request success","Success");
        }


    }
    @PostMapping("/removeLocation/{locationId}")
    public ResponseEntity removeLocation(@PathVariable Integer locationId){
        if(locationService.checkStatus(locationId)){
            locationService.removeLocation(locationId);

            return new ResponseEntity(200,"success","Delete Success");
        }else {
            return new ResponseEntity(201,"failed","Location in use");
        }


    }


    @GetMapping("/get/all")
    /*
    *   获取所有床位信息
    **/
    public ResponseEntity getAllLocations(){
        return new ResponseEntity(200,"Success",locationService.getAllLocation());
    }

    @GetMapping("/get/allNoBind")
    /*
     *   获取所有床位信息
     **/
    public ResponseEntity getLocationsByNoBind(){
        return new ResponseEntity(200,"Success",locationService.getLocationByStatus(1));
    }


}
