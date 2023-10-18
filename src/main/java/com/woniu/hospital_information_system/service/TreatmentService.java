package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.DTO.OmdDTO;
import com.woniu.hospital_information_system.entity.DTO.TreatmentDTO;
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
    //门诊发药查询(根据已发药、未发药、发药日期、病人就诊号)
    List<OmdVO> selectOmd(OmdDTO omdDTO);
    //门诊发药操作 根据费用ID，修改门诊病人费用表中的操作状态码  根据医嘱ID插入发药时间
    void updateMsById(@Param("vbids") List<Integer> vbids);
    void updateDtById(@Param("coids")  List<Integer> coids);
    //门诊发药，根据项目ID减少库存
    void updatestorageById(OmdVO omdVO);
}
