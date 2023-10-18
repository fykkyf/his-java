package com.woniu.hospital_information_system.controller;


import com.woniu.hospital_information_system.entity.PatientRaidology;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.service.PatientRaidologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("patientRaidology")
public class PatientRaidologyController {

    @Autowired
    PatientRaidologyService patientRaidologyService;

    @PostMapping("/upload")
    //住院检查处，上传图片
    public ResponseEntity upload(@RequestParam(value = "file",required = false) MultipartFile file, PatientRaidology PatientRaidology) throws IOException {
        Integer PatientRaidologyId = PatientRaidology.getPatientRaidologyId();
        // 判断文件是否为空
        if(file.isEmpty()){
            return new ResponseEntity(402,"文件为空",null);
        }
        // 获取传过来的文件名字
        String OriginalFilename=file.getOriginalFilename();
        // 为了防止重名覆盖，获取系统时间戳+原始文件的后缀名
        String fileName=System.currentTimeMillis()+"."+OriginalFilename.substring(OriginalFilename.lastIndexOf(".")+1);
        // 设置保存地址（这里是转义字符）
        //1.后台保存位置
        String path = "D:\\vue_project\\travel\\src\\assets\\images\\";
        //dest是上传图片的路径名字
        File dest=new File(path+fileName);
        // 判断文件是否存在
        if(!dest.getParentFile().exists()){
            // 不存在就创建一个
            dest.getParentFile().mkdirs();
        }
        try {
            // 后台上传
            patientRaidologyService.addPicture(path,fileName,PatientRaidologyId);
            file.transferTo(dest);
            return new ResponseEntity(200, "文件上传成功", fileName);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(400, "文件上传失败", null);
        }
    }

    @PostMapping("/getPictureFileName")
    //住院医生界面，带着visitorInfo_id去住院检查表中查出图片的名字fileName
    public ResponseEntity getPictureFileName(@RequestBody VisitorInfo visitorInfo){
        String fileName=patientRaidologyService.getPictureFileName(visitorInfo);
        return new ResponseEntity(200,"ok",fileName);
    }
}
