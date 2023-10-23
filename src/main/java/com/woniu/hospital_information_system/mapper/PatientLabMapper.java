package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.DTO.ClinicLabDTO;
import com.woniu.hospital_information_system.entity.DTO.PatientLabDTO;
import com.woniu.hospital_information_system.entity.VO.PatientLabVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PatientLabMapper {
    //查询住院检验明细
    List<PatientLabVO> getAllPatientLab(PatientLabDTO patientLabDTO);

    //住院检验结果上传
    @Update("update patient_lab set lab_result=#{labResult},test_date=now(),test_status=2 where patient_lab_id=#{patientLabId}")
    void updateAllPatientLab(PatientLabDTO patientLabDTO);
    //上传结果 修改费用表状态码
    @Update("update patient_bill set manipulate_status=2 where patient_bill_id=#{patientBillId}")
    void updatePb(PatientLabDTO patientLabDTO);

}
