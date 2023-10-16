package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.DTO.TreatmentDTO;
import com.woniu.hospital_information_system.entity.VO.TreatmentVO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
@Mapper
public interface TreatmentMapper {
    //查询所有项目明细(可条件查询，也可查所有 )根据项目名称和厂家名称查询
    List<TreatmentVO> selectAllTreatment(TreatmentDTO treatmentDTO);

}
