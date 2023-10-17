package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PatientBillMapper {
    @Insert("insert into patient_bill values (null,#{patientId},7,null,0,null,null,1,1)")
    void dischargePatient(PatientInfoDTO patientInfoDTO);
}
