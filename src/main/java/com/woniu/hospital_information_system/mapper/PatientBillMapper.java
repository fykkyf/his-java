package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.PatientBill;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PatientBillMapper {
    //添加出院费用
    @Insert("insert into patient_bill values (null,#{patientId},7,null,0,null,null,1,1)")
    void dischargePatient(PatientInfoDTO patientInfoDTO);
    @Update("update patient_bill set manipulate_status = 2 where patient_id = #{patientId} and treatment_id = 7")
    void completeDischarge(PatientInfoDTO patientInfoDTO);
    //添加住院费用明细
    @Insert("insert into patient_bill values (null,#{patientId},#{treatmentId},#{drugCount},#{treatmentPrice},now(),null,2,1)")
    void insertPatientBill(PatientBill patientBill);
}
