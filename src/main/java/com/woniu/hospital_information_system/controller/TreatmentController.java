package com.woniu.hospital_information_system.controller;

import cn.hutool.core.date.DateTime;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.hospital_information_system.entity.DTO.ImdDTO;
import com.woniu.hospital_information_system.entity.DTO.OmdDTO;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.DTO.TreatmentDTO;
import com.woniu.hospital_information_system.entity.Treatment;
import com.woniu.hospital_information_system.entity.VO.ImdVO;
import com.woniu.hospital_information_system.entity.VO.OmdVO;
import com.woniu.hospital_information_system.entity.VO.TreatmentVO;
import com.woniu.hospital_information_system.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/treatment")
public class TreatmentController {
    @Autowired
    TreatmentService treatmentService;
    //给医生下医嘱用(医生)
    //查询所有项目信息，前端判断项目类型 后端写死启用类型为1 启用 如果是药品，设置库存>=1的条件
    @PostMapping("/selectAllTreatmentByCategory")
    public Object selectAllTreatmentByCategory(@RequestBody  TreatmentDTO treatmentDTO){
        System.out.println(treatmentDTO);
        treatmentDTO.setTreatmentStatus(1);
        if (treatmentDTO.getTreatmentCategory()!=null && treatmentDTO.getTreatmentCategory()==1){
            treatmentDTO.setStorage(1);
        }
        return new ResponseEntity(200,"",treatmentService.selectAllTreatment(treatmentDTO));

    }
    //近期药品处理、药房盘点，减少库存
    @PostMapping("/reduceStorage")
    public Object reduceStorage(@RequestBody  TreatmentDTO treatmentDTO){
        treatmentService.reduceStorage(treatmentDTO);
        return new ResponseEntity(200,"","ok");
    }
    //药品入库
    @PostMapping("/warehousing")
    public Object warehousing(@RequestBody  TreatmentDTO treatmentDTO){
        treatmentService.warehousing(treatmentDTO);
        return new ResponseEntity(200,"","ok");
    }
    //药房管理
    //查询药品 多条件查询(项目名称、生产厂家、过期日期、是否启用、)
    @PostMapping("/selectAllTreatment1")
    public Object selectAllTreatment1(@RequestBody  TreatmentDTO treatmentDTO){
        treatmentDTO.setTreatmentCategory(1);
        //分页
        PageHelper.startPage(treatmentDTO.getPageNum(),treatmentDTO.getPageSize());
        //查询
        List<TreatmentVO> treatmentVOS = treatmentService.selectAllTreatment(treatmentDTO);
        //获取分页信息
        PageInfo<TreatmentVO> pageInfo = new PageInfo<>(treatmentVOS);

        return new ResponseEntity(200,"",pageInfo);
    }

    //初始化加载，库存警告  查询库存<=10的药品
    @PostMapping("/selectAllTreatment2")
    public Object selectAllTreatment2(@RequestBody  TreatmentDTO treatmentDTO){
        treatmentDTO.setTreatmentCategory(1);
        treatmentDTO.setTreatmentStatus(1);
        List<TreatmentVO> treatmentVOS = treatmentService.selectAllTreatment(treatmentDTO);
        List<String> treatmentVOS1 = new ArrayList<>();
        for (TreatmentVO treatmentVO : treatmentVOS){
            if (treatmentVO.getStorage()<=10){
                treatmentVOS1.add("编号:"+treatmentVO.getDrugCode()+":"+treatmentVO.getTreatmentName()+"库存还有"+treatmentVO.getStorage()+"，请尽快补货！");
            }
        }
        return new ResponseEntity(200,"",treatmentVOS1);
    }
    //初始化加载，近期药品警告
    @PostMapping("/selectAllTreatment3")
    public Object selectAllTreatment3(@RequestBody  TreatmentDTO treatmentDTO){
        treatmentDTO.setTreatmentCategory(1);
        treatmentDTO.setTreatmentStatus(1);
        List<TreatmentVO> treatmentVOS = treatmentService.selectAllTreatmentByExptime(treatmentDTO);
        List<String> treatmentVOS1 = new ArrayList<>();
        for (TreatmentVO treatmentVO : treatmentVOS){
            if(treatmentVO.getExpiredTime()!=null){
                treatmentVOS1.add("编号"+treatmentVO.getDrugCode()+":"+treatmentVO.getTreatmentName()+"10天内过期，请及时处理！");
            }
        }
        return new ResponseEntity(200,"",treatmentVOS1);

    }


    //药品添加 根据国家药品编号查询，如果药品不存在，insert一条新的数据，如果存在，更改药品库存库存
    @PostMapping("/addTreatment1")
    public Object addTreatment1(@RequestBody  TreatmentDTO treatmentDTO){
        System.out.println(treatmentDTO);
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
         //分页
         PageHelper.startPage(treatmentDTO.getPageNum(),treatmentDTO.getPageSize());
         //查询
         List<TreatmentVO> treatmentVOS = treatmentService.selectAllTreatments(treatmentDTO);
         //获取分页信息
         PageInfo<TreatmentVO> pageInfo = new PageInfo<>(treatmentVOS);
         return new ResponseEntity(200,"",pageInfo);
     }
    //修改药品信息/药房
    @PostMapping("/updateTreatment")
    public Object updateTreatment(@RequestBody  TreatmentDTO treatmentDTO){
        treatmentService.updateTreatment(treatmentDTO);
        return new ResponseEntity(200,"","修改成功！");
    }

    //添加项目 (管理员)
    @PostMapping("/addTreatment")
    public Object addTreatment(@RequestBody  TreatmentDTO treatmentDTO){
        if (treatmentService.selectTreatmentByName(treatmentDTO)!=null){
            return new ResponseEntity(201,"","项目已存在，请勿重复添加！");
        }else{
            System.out.println(treatmentDTO);
            treatmentService.addTreatment1(treatmentDTO);
            return new ResponseEntity(200,"","添加完成");
        }
    }

    //门诊发药查询
    //门诊发药查询、根据下单日期(前端默认当天日期)/门诊就诊ID 查询需要发药的患者ID和姓名
    @PostMapping("/selectVisitorByOmd")
    public Object selectVisitorByOmd(@RequestBody OmdDTO omdDTO){
        return new ResponseEntity(200,"",treatmentService.selectVisitorByOmd(omdDTO));
    }
    //根据门诊号或者日期查询明细
    @PostMapping("/selectOmd")
    public Object selectOmd(@RequestBody OmdDTO omdDTO){
            System.out.println(omdDTO);
            return new ResponseEntity(200,"",treatmentService.selectOmd(omdDTO));
    }

    //门诊发药操作
    @Transactional
    @PostMapping("/omd")
    public Object omd(@RequestBody  List<OmdVO> omdVOS){
        System.out.println(omdVOS);
        List<Integer> vbids = new ArrayList<>();
        for (OmdVO omdVO:omdVOS){
            treatmentService.updatestorageById(omdVO);
            System.out.println(omdVO.getVisitorBillId());
            vbids.add(omdVO.getVisitorBillId());
            System.out.println(vbids);
        }
        treatmentService.updateMsById(vbids);
        return new ResponseEntity(200,"","发药完成！");
    }


    //住院发药查询、根据记账日期(前端默认当天日期)/住院ID(可传) 查询需要发药的患者ID和姓名
    @PostMapping("/selectPatientByImd")
    public Object selectPatientByImd(@RequestBody ImdDTO imdDTO){
        return new ResponseEntity(200,"",treatmentService.selectPatientByImd(imdDTO));
    }
    //根据住院号或者日期查询明细
    @PostMapping("/selectImd")
    public Object selectImd(@RequestBody ImdDTO imdDTO){
        return new ResponseEntity(200,"",treatmentService.selectImd(imdDTO));
    }

    //住院发药操作
    @Transactional
    @PostMapping("/imd")
    public Object imd(@RequestBody  List<ImdVO> imdVOS){
        List<Integer> pbids = new ArrayList<>();
        for (ImdVO imdVO:imdVOS){
            treatmentService.updatestorageByImId(imdVO);
            pbids.add(imdVO.getPatientBillId());
        }
        treatmentService.updatePbById(pbids);
        return new ResponseEntity(200,"","发药完成！");
    }

    //门诊已发药查询汇总
    @PostMapping("/selectClinicMed")
    public Object selectClinicMed(@RequestBody  OmdDTO omdDTO){
        return new ResponseEntity(200,"",treatmentService.selectClinicMed(omdDTO));
    }
    //门诊已发药查询明细
    @PostMapping("/selectClinicMedmx")
    public Object selectClinicMedmx(@RequestBody  OmdDTO omdDTO){
        return new ResponseEntity(200,"",treatmentService.selectClinicMedmx(omdDTO));
    }

    //住院已发药查询汇总
    @PostMapping("/selectPatientMed")
    public Object selectPatientMed(@RequestBody  ImdDTO imDTO){
        return new ResponseEntity(200,"",treatmentService.selectPatientMed(imDTO));
    }

    //住院已发药查询明细
    @PostMapping("/selectPatientMedmx")
    public Object selectPatientMedmx(@RequestBody  ImdDTO imDTO){
        return new ResponseEntity(200,"",treatmentService.selectPatientMedmx(imDTO));
    }


}
