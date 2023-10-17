package com.woniu.hospital_information_system.mapper;


import com.woniu.hospital_information_system.entity.PatientInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface PatientInfoMapper {
    //查询所有住院患者信息
    @Select("select * from patient_info")
    List<PatientInfo> selectAllPatientInfos();
    //添加住院患者信息
    void insertPatientInfo(PatientInfo patientInfo);
    //根据身份证号查询住院患者信息
    List<PatientInfo> selectPatientInfoByIdNumber(String idNumber);
    @Select("select * from patient_info where patient_id = #{patientIndoId}")
    PatientInfo selectPatientInfoByPatientInfoId(int patientInfoId);
    //添加床位id
    @Update("update patient_info set location_id = #{locationId} where patient_id = #{patientId}")
    void updatePatientInfoByPatientInfoId(@Param("patientId") int patientId, @Param("locationId") int locationId);
}
