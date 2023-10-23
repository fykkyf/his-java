package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.DTO.ClinicLabDTO;
import com.woniu.hospital_information_system.entity.VO.ClinicLabVO;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ClinicLabService {
    //条件查询所有门诊检验明细
    List<ClinicLabVO> getAllClinicLab(ClinicLabDTO clinicLabDTO);

    //门诊检验结果上传

    void updateAllClinicLab(ClinicLabDTO clinicLabDTO);
    //上传结果 修改费用表状态码

    void updateVb(ClinicLabDTO clinicLabDTO);
}
