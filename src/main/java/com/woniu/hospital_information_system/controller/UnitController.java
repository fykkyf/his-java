package com.woniu.hospital_information_system.controller;


import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.Unit;
import com.woniu.hospital_information_system.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/update")
    public ResponseEntity updateUnit(@RequestBody Unit unit){
        if (unit.getUnitId()==null){
            unitService.add(unit);
            return new ResponseEntity(200,"添加成功",null);
        }else {
            unitService.update(unit);
            return new ResponseEntity(200,"修改成功",null);
        }

    }
    @RequestMapping("/remove/{unitId}")
    public ResponseEntity removeUnit(@PathVariable int unitId){
        unitService.removeUnit(unitId);
        return new ResponseEntity(200,"success","删除成功");
    }
}
