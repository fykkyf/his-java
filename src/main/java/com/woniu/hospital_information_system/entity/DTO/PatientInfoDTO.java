package com.woniu.hospital_information_system.entity.DTO;

import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientInfoDTO {
    private Integer patientId;
    private Integer visitorId;
    private String patientName;
    private Integer gender;
    private Integer age;
    private String idNumber;
    private Integer unitId;
    private Integer doctorId;
    private Integer insuranceStatus;
    private DateTime inTime;
    private DateTime outTime;
    private Integer clinicDiagnosisId;
    private Integer admissionDiagnosisId;
    private Integer dischargeDiagnosisId;
    private Integer locationId;
    private DateTime paidTime;
    private Integer stayStatus;
    private Integer paymentStatus;
}
