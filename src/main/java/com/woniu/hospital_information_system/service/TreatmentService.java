package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.DTO.TreatmentDTO;
import com.woniu.hospital_information_system.entity.VO.TreatmentVO;
import org.apache.ibatis.annotations.Insert;
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
}
