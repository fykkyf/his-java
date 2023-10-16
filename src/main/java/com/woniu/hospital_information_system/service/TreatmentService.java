package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.DTO.TreatmentDTO;
import com.woniu.hospital_information_system.entity.VO.TreatmentVO;

import java.util.List;

public interface TreatmentService {
    //查询所有项目明细(可条件查询，也可查所有)
    List<TreatmentVO> selectAllTreatment(TreatmentDTO treatmentDTO);
}
