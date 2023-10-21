package com.woniu.hospital_information_system.entity.VO;

import com.woniu.hospital_information_system.entity.PatientInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientBillResultVO {
    private List<PatientBillVO> patientBillVOList;
    private PatientInfo patientInfo;
    private Double finalPrice;


}
