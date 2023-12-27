package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.Dosage;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.Unit;
import com.woniu.hospital_information_system.service.AdministrationService;
import com.woniu.hospital_information_system.service.DosageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dosage")
public class DosageController {
    @Autowired
    DosageService dosageService;

    @GetMapping("/getAll")
    /*
    *   获取所有用法信息
    **/
    public ResponseEntity getAllDosages(){
        return new ResponseEntity(200,"查询成功",dosageService.getAllDosages());
    }
    @PostMapping("/update")
    public ResponseEntity updateDosage(@RequestBody Dosage dosage){
        if (dosage.getDosageId()==null){
            dosageService.addDosage(dosage);
            return new ResponseEntity(200,"添加成功",null);
        }else {
            dosageService.updateDosage(dosage);
            return new ResponseEntity(200,"修改成功",null);
        }

    }
    @RequestMapping("/remove/{dosageId}")
    public ResponseEntity removeDosage(@PathVariable int dosageId){
        dosageService.removeDosage(dosageId);
        return new ResponseEntity(200,"success",null);
    }

}
