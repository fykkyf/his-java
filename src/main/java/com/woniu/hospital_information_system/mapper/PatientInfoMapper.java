package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.PatientInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface PatientInfoMapper {
    @Select("select * from patientInfo")
    List<PatientInfo> selectAllPatientInfo();
}
