package com.woniu.hospital_information_system.entity.DTO;

import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime inTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime outTime;
    private Integer clinicDiagnosisId;
    private Integer admissionDiagnosisId;
    private Integer dischargeDiagnosisId;
    private Integer locationId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime paidTime;
    private Integer stayStatus;
    private Integer paymentStatus;
}
