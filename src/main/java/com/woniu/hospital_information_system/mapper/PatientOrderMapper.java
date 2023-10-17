package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.DTO.PatientOrderDTO;
import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.entity.PatientOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    @Insert("insert into patient_order values (null,#{patientId},#{doctorId},7,'办理出院',null,null,null,null,null,0,0)")
    void dischargePatient(PatientInfoDTO patientInfoDTO);
}
