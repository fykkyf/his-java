package com.woniu.hospital_information_system.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDailyOrderVO {
    private Integer patientBillId;
    private Integer patientId;
    private String patientName;
    private Integer treatmentId;
    private String treatmentName;
    private Integer drugCount;
    private Double amount;
    private List<PatientDailyOrderVO> patientBills;
    private Integer pageNum;
    private Integer pageSize;
    private Integer total;
}
