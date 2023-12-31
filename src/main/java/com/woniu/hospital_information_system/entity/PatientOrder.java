package com.woniu.hospital_information_system.entity;

import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
//住院医嘱表
public class PatientOrder {
    private Integer patientOrderId;
    private PatientInfo patient;
    private Employee employee;
    private Integer treatmentId;
    private String treatmentName;
    private Administration administration;
    private Dosage dosage;
    private Integer treatmentCount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime executionTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dispenseTime;
    private Integer executionStatus;
    private Integer orderType;
    private Integer flog;
}
