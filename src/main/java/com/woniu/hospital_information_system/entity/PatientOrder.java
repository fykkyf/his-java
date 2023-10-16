package com.woniu.hospital_information_system.entity;

import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//住院医嘱表
public class PatientOrder {
    private Integer patientOrderId;
    private Integer patientId;
    private Integer doctorId;
    private Integer treatmentId;
    private String treatmentName;
    private Integer administrationId;
    private Integer dosageId;
    private Integer treatmentCount;
    private DateTime executionTime;
    private DateTime dispenseTime;
    private Integer executionStatus;
    private Integer orderType;
}
