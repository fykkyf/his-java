package com.woniu.hospital_information_system.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientBillVO {
    private Integer patientBillId;
    private Integer patientId;
    private Integer treatmentId;
    private String treatmentName;
    private Integer drugCount;
    private Double treatmentPrice;
    private Double insurancePrice;
    private Double finalPrice;
}
