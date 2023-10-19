package com.woniu.hospital_information_system.mapper;


import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
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
    //根据病人id查询住院患者信息
    @Select("select * from patient_info where patient_id = #{patientId}")
    PatientInfo selectPatientInfoByPatientId(int patientId);
    //更新床位id
    @Update("update patient_info set location_id = #{locationId} where patient_id = #{patientId}")
    void updatePatientInfoByPatientInfoId(@Param("patientId") int patientId, @Param("locationId") int locationId);
    //添加出院诊断
    @Update("update patient_info set discharge_diagnosis_id = #{dischargeDiagnosisId} where patient_id = #{patientId}")
    void dischargeDiagnosis(PatientInfo patientInfo);
    //清空床位信息
    @Update("update  patient_info set location_id = null where patient_id = #{patientId}")
    void updateLocationId(Integer patientId);
    //办理出院
    @Update("update  patient_info set stay_status = 2,out_time = now()  where patient_id = #{patientId}")
    void completeDischarge(PatientInfoDTO patientInfoDTO);
    //修改住院患者信息-转科
//    @Update("update patient_info set unit_id = #{unitId},doctor_id = #{doctorId} where patient_id = #{patientId} ")
    void updatePatientInfo(PatientInfo patientInfo);
    //添加入院诊断
    @Update("update patient_info set admission_diagnosis_id = #{admissionDiagnosisId} where patient_id = #{patientId}")
    void admissionDiagnosis(PatientInfo patientInfo);
    //根据关键字查询
    List<PatientInfo> selectPatientInfoByKeyWord(PatientInfo convertPatientInfo);
}
