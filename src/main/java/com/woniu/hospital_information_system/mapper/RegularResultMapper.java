package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.RegularResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RegularResultMapper {
    //根据patientId查询三测信息
    @Select("select * from regualar_test where patient_id = #{patientId}")
    List<RegularResult> selectRegularByPatientId(Integer patientId);
}
