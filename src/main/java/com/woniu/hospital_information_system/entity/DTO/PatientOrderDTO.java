package com.woniu.hospital_information_system.entity.DTO;

import cn.hutool.core.date.DateTime;
import com.woniu.hospital_information_system.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientOrderDTO {
    private Integer patientOrderId;
    private PatientInfo patient;
    private Employee employee;
    private TreatmentDTO treatment;
    private Administration administration;
    private Dosage dosage;
    private Integer administrationId;
    private Integer dosageId;
    private Integer treatmentCount;
    private DateTime executionTime;
    private DateTime dispenseTime;
    private Integer executionStatus;
    private Integer orderType;
    private Disease admissionDiagnosis;
    private Disease dischargeDiagnosis;
    private Integer pageNum;
    private Integer pageSize;
}
