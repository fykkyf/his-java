package com.woniu.hospital_information_system.controller;


import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.Unit;
import com.woniu.hospital_information_system.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;



/*
 * 科室
 * */
@RestController
@RequestMapping("unit")
public class UnitController {

    @Autowired
    UnitService unitService;
    @GetMapping("/getAll")
    //查出所有科室
    public ResponseEntity getAllUnits(){
        List<Unit> allUnits = unitService.getAllUnits();
        return new ResponseEntity(200,"ok",allUnits);
    }
}
