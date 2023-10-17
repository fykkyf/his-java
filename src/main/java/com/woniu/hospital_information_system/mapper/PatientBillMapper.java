package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.PatientBill;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PatientBillMapper {
    @Insert("insert into patient_bill values (null,#{patientId},7,null,0,null,null,1,1)")
    void dischargePatient(PatientInfoDTO patientInfoDTO);
    @Update("update patient_bill set manipulate_status = 2 where patient_id = #{patientId} and treatment_id = 7")
    void completeDischarge(PatientInfoDTO patientInfoDTO);
    @Insert("insert into patient_bill values (null,#{patientId},#{treatmentId},#{drugCount},#{treatmentPrice},now(),null,2,1)")
    void insertPatientBill(PatientBill patientBill);
}
