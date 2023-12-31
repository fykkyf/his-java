package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.DTO.ImdDTO;
import com.woniu.hospital_information_system.entity.DTO.OmdDTO;
import com.woniu.hospital_information_system.entity.DTO.TreatmentDTO;
import com.woniu.hospital_information_system.entity.VO.ImdVO;
import com.woniu.hospital_information_system.entity.VO.OmdVO;
import com.woniu.hospital_information_system.entity.VO.TreatmentVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TreatmentService {
    //查询所有项目明细(可条件查询，也可查所有)
    List<TreatmentVO> selectAllTreatment(TreatmentDTO treatmentDTO);

    //根据国家药品编码查询药品是否存在
    List<TreatmentVO> selectAllByCode(TreatmentDTO treatmentDTO);

    //添加新的药品 默认启用1 类型药品0
    void addTreatment(TreatmentDTO treatmentDTO);
    //药品如果存在，只增加库存
    void updateStorage(TreatmentDTO treatmentDTO);
    //药品近期查询
    List<TreatmentVO> selectAllTreatmentByExptime(TreatmentDTO treatmentDTO);
    //修改药品信息
    void updateTreatment(TreatmentDTO treatmentDTO);
    //医生下达医嘱，减少库存
    void reduceStorage(TreatmentDTO treatmentDTO);
    //管理员添加项目明细，根据项目名称查询
    TreatmentVO selectTreatmentByName(TreatmentDTO treatmentDTO);
    //如果根据名称没有查到，管理员添加项目明细
    void addTreatment1(TreatmentDTO treatmentDTO);
    //门诊发药查询、根据下单日期(前端默认当天日期)/门诊就诊ID 查询需要发药的患者ID和姓名
    List<OmdVO> selectVisitorByOmd(OmdDTO omdDTO);
    //门诊发药查询(根据已发药、未发药、发药日期、病人就诊号)
    List<OmdVO> selectOmd(OmdDTO omdDTO);
    //门诊发药操作 根据费用ID，修改门诊病人费用表中的操作状态码  根据医嘱ID插入发药时间
    void updateMsById(@Param("vbids") List<Integer> vbids);

    //门诊发药，根据项目ID减少库存
    void updatestorageById(OmdVO omdVO);

    //住院发药查询、根据记账日期(前端默认当天日期)/住院ID(可传) 查询需要发药的患者ID和姓名
    List<ImdVO> selectPatientByImd(ImdDTO imdDTO);
    //住院发药查询(根据未发药、病人住院号 可选:发药日期 前端默认当天  记账状态：已记账)
    List<ImdVO> selectImd(ImdDTO imdDTO);
    //住院发药操作 根据费用ID，修改住院病人费用表中的操作状态码  插入发药时间
    void updatePbById(@Param("pbids") List<Integer> pbids);
    //住院发药，根据项目ID减少库存
    @Update("update treatment set storage =storage-#{drugCount} where drug_code=drugCode")
    void updatestorageByImId(ImdVO imdVO);

    //药品入库
    @Update("update treatment set storage=storage+#{storage1} where drug_code=#{drugCode}")
    void warehousing(TreatmentDTO treatmentDTO);

    //门诊已经发药查询汇总、根据下单日期(前端默认当天日期)/门诊就诊ID(可传) 查询需要发药的患者ID和姓名
    List<OmdVO> selectClinicMed(OmdDTO omdDTO);
    //门诊已经发药查询明细(根据未发药、病人就诊号 可选:发药日期 前端默认当天  支付状态：待定)
    List<OmdVO> selectClinicMedmx(OmdDTO omdDTO);

    //住院已经发药查询汇总、根据记账日期(前端默认当天日期)/住院ID(可传) 查询需要发药的患者ID和姓名
    List<ImdVO> selectPatientMed(ImdDTO imdDTO);
    //住院已经发药查询明细、根据记账日期(前端默认当天日期)/住院ID(可传) 查询需要发药的患者ID和姓名
    List<ImdVO> selectPatientMedmx(ImdDTO imdDTO);
    //查询所有非药品明细
    List<TreatmentVO> selectAllTreatments(TreatmentDTO treatmentDTO);

}
