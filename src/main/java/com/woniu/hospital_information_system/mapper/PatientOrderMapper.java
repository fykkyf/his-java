package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.DTO.PatientOrderDTO;
import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.entity.PatientOrder;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PatientOrderMapper {
    //获取所有住院医嘱信息
    @Select("select * from patient_order")
    List<PatientInfo> selectAllPatientOrders();
    //给住院患者下医嘱
    void addPatientOrderByPatientOrderId(PatientOrder patientOrder);
    @Select("select * from patient_order where patient_id = #{patientId}")
    PatientInfo selectPatientOrderByPatientId(int patientId);
    @Update("")
    void updatePatientOrderByPatientId(PatientOrderDTO patientOrderDTO);
    @Insert("insert into patient_order values (null,#{patientId},#{doctorId},7,'办理出院',null,null,null,null,null,1,1)")
    void dischargePatient(PatientInfoDTO patientInfoDTO);
    @Update("update patient_order set execution_status = #{executionStatus} where patient_id = #{patientId}")
    void checkDischarge(@Param("executionStatus")int executionStatus, @Param("patientId")int patientId);
}
