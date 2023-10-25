package com.woniu.hospital_information_system.controller;


import com.woniu.hospital_information_system.entity.ClinicRaidology;
import com.woniu.hospital_information_system.entity.FormData;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.service.ClinicRaidologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("clinicRaidology")
public class ClinicRaidologyController {

    @Autowired
    ClinicRaidologyService clinicRaidologyService;

    @PostMapping("/upload")
    //门诊检查处，上传图片
    public ResponseEntity upload(FormData formData) throws IOException {
        MultipartFile file = formData.getFile();
        Integer clinicRaidologyId = formData.getId();
        System.out.println("这里是clinicRaidologyId:"+clinicRaidologyId);
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
//        String path = "D:\\vscode\\code\\his\\his\\src\\assets\\images\\";
        String path = "E:\\project\\study\\his\\src\\assets\\images\\";
        //dest是上传图片的路径名字
        File dest=new File(path+fileName);
        System.out.println("这里是dest："+dest);
        // 判断文件是否存在
        if(!dest.getParentFile().exists()){
            // 不存在就创建一个
            dest.getParentFile().mkdirs();
        }
        try {
            // 后台上传
            clinicRaidologyService.addPicture(path,fileName,clinicRaidologyId);
            file.transferTo(dest);
            return new ResponseEntity(200, "文件上传成功", fileName);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(400, "文件上传失败", null);
        }
    }

    @PostMapping("/getPictureFileName/{visitorId}")
    //在门诊医生界面，带着visitorInfo_id去门诊检查表中查出图片的名字fileName
    public ResponseEntity getPictureFileName(@PathVariable("visitorId") Integer visitorId){
        System.out.println("这里是controller:"+visitorId);
        String fileName=clinicRaidologyService.getPictureFileName(visitorId);
        System.out.println(fileName);
        return new ResponseEntity(200,"ok",fileName);
    }
}
