package com.woniu.hospital_information_system.entity.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.woniu.hospital_information_system.entity.Disease;
import com.woniu.hospital_information_system.entity.Employee;
import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.entity.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
//住院患者信息表
public class PatientInfoVO {
    private List<PatientInfo> patientInfos;
    private Integer pageSize;
    private Integer pageNum;
    private Integer total;
}
