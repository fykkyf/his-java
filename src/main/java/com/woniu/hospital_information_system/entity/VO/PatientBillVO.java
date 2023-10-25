package com.woniu.hospital_information_system.entity.VO;

import com.woniu.hospital_information_system.entity.PatientOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientBillVO {
    private Integer patientBillId;
    private Integer patientId;
    private String patientName;
    private Integer treatmentId;
    private String treatmentName;
    private Integer drugCount;
    private Double treatmentPrice;
    private Double amount;
    private Double insurancePrice;
    private Double finalPrice;
    private boolean paystatus;
    private Integer executionStatus;
    private Integer orderType;
    private List<PatientBillVO> patientBills;
    private Integer pageNum;
    private Integer pageSize;
    private Integer total;
}
