package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.DTO.ClinicLabDTO;
import com.woniu.hospital_information_system.entity.VO.ClinicLabVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ClinicLabMapper {
    //条件查询所有门诊检验明细
    List<ClinicLabVO> getAllClinicLab(ClinicLabDTO clinicLabDTO);

    //门诊检验结果上传
    @Update("update clinic_lab set lab_result=#{labResult},test_date=now(),test_status=2 where clinic_lab_id=#{clinicLabId}")
    void updateAllClinicLab(ClinicLabDTO clinicLabDTO);
    //上传结果 修改费用表状态码
    @Update("update visitor_bill set manipulate_status=2 where visitor_bill_id=#{visitorBillId}")
    void updateVb(ClinicLabDTO clinicLabDTO);
}
