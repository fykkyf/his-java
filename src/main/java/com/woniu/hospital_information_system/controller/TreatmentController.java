package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.DTO.TreatmentDTO;
import com.woniu.hospital_information_system.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/treatment")
public class TreatmentController {
    @Autowired
    TreatmentService treatmentService;
    //给医生下医嘱用(医生)
    //查询所有项目信息，前端判断项目明细 后端写死启用类型为1 启用
    @PostMapping("/selectAllTreatmentByCategory")
    public Object selectAllTreatmentByCategory(@RequestBody  TreatmentDTO treatmentDTO){
        treatmentDTO.setTreatmentStatus(1);
        return new ResponseEntity(200,"",treatmentService.selectAllTreatment(treatmentDTO));
    }
    //医生下达医嘱/药房盘点，减少库存
    @PostMapping("/reduceStorage")
    public Object reduceStorage(@RequestBody  TreatmentDTO treatmentDTO){
        treatmentService.reduceStorage(treatmentDTO);
        return new ResponseEntity(200,"","ok");
    }
    //药房管理
    //查询药品 多条件查询(项目名称、生产厂家、过期日期、是否启用、)
    @PostMapping("/selectAllTreatment1")
    public Object selectAllTreatment1(@RequestBody  TreatmentDTO treatmentDTO){
        treatmentDTO.setTreatmentCategory(1);
        return new ResponseEntity(200,"",treatmentService.selectAllTreatment(treatmentDTO));
    }

    //根据国家药品编号查询，如果药品不存在，insert一条新的数据，如果存在，更改药品库存库存
    @PostMapping("/addTreatment")
    public Object addTreatment(@RequestBody  TreatmentDTO treatmentDTO){
        if ((treatmentService.selectAllByCode(treatmentDTO)).size()==0){
            treatmentService.addTreatment(treatmentDTO);
        }else{
            treatmentService.updateStorage(treatmentDTO);
        }
        return new ResponseEntity(200,"","添加完成");
    }

     //整个项目明细查询、修改(管理员)
     //查询所有项目信息，前端判断项目明细和启用类型
     @PostMapping("/selectAllTreatment")
     public Object selectAllTreatment(@RequestBody  TreatmentDTO treatmentDTO){
         return new ResponseEntity(200,"",treatmentService.selectAllTreatment(treatmentDTO));
     }
    //修改项目信息（管理员）
    @PostMapping("/updateTreatment")
    public Object updateTreatment(@RequestBody  TreatmentDTO treatmentDTO){
        treatmentService.updateTreatment(treatmentDTO);
        return new ResponseEntity(200,"","修改成功！");
    }





}
