package com.woniu.hospital_information_system.mapper;


import com.woniu.hospital_information_system.entity.PatientInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface PatientInfoMapper {
    //查询所有住院患者信息
    @Select("select * from patient_info")
    List<PatientInfo> selectAllPatientInfo();
    //添加住院患者信息
    void insertPatientInfo(PatientInfo patientInfo);
}
