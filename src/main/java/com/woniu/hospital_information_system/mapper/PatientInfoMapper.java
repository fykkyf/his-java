package com.woniu.hospital_information_system.mapper;


import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.PatientInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface PatientInfoMapper {
    //查询所有住院患者信息
//    @Select("select * from patient_info")
    List<PatientInfo> selectAllPatientInfos();
    //添加住院患者信息
    void insertPatientInfo(PatientInfo patientInfo);
    //根据身份证号查询住院患者信息
    List<PatientInfo> selectPatientInfoByIdNumber(String idNumber);
    //根据病人id查询住院患者信息
//    @Select("select * from patient_info where patient_id = #{patientId}")
    PatientInfo selectPatientInfoByPatientId(int patientId);
    //更新床位id
    @Update("update patient_info set location_id = #{locationId} where patient_id = #{patientId}")
    void updatePatientInfoByPatientInfoId(@Param("patientId") int patientId, @Param("locationId") int locationId);
    //添加出院诊断
    @Update("update patient_info set discharge_diagnosis_id = #{dischargeDiagnosis.diseaseId} where patient_id = #{patientId}")
    void dischargeDiagnosis(PatientInfo patientInfo);
    //清空床位信息
    @Update("update  patient_info set location_id = null where patient_id = #{patientId}")
    void updateLocationId(Integer patientId);
    //给病人添加床位
    @Update("update  patient_info set location_id = #{locationId} where patient_id = #{patientId}")
    void addLocationId(@Param("locationId")Integer locationId,@Param("patientId") Integer patientId);
    //办理出院
    @Update("update  patient_info set stay_status = 2,out_time = now()  where patient_id = #{patientId}")
    void completeDischarge(PatientInfoDTO patientInfoDTO);
    //修改住院患者信息-转科
//    @Update("update patient_info set unit_id = #{unitId},doctor_id = #{doctorId} where patient_id = #{patientId} ")
    void updatePatientInfo(PatientInfo patientInfo);
    //添加入院诊断
    @Update("update patient_info set admission_diagnosis_id = #{admissionDiagnosis.diseaseId} where patient_id = #{patientId}")
    void admissionDiagnosis(PatientInfo patientInfo);
    //根据关键字查询
    List<PatientInfo> selectPatientInfoByKeyWord(PatientInfo convertPatientInfo);
    //出院结算更新支付时间+支付状态
    @Update("update patient_info set payment_status = 2, paid_time = now() where patient_id = #{patientId}")
    void finishPayment(Integer patientId );
    //查询未安排床位信息的住院患者信息
    List<PatientInfo> selectPatientInfosByNoLocation();
    //根据关键字查询--添加床位查询
    List<PatientInfo> selectNoLocationPatientInfosByKeyWord(PatientInfo convertPatientInfo);
    //查询有出院诊断--未办理出院的病人信息
    List<PatientInfo> selectPatientInfosByDischarge(int patientId);
    @Select("select * from patient_info where doctor_id = #{doctorId} and stay_status = 1")
    List<PatientInfo> selectPatientInfoByDoctorId(Integer doctorId);
}
