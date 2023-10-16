package com.woniu.hospital_information_system.entity.DTO;

import cn.hutool.core.date.DateTime;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientInfoDTO {
    //门诊患者信息
    private Integer patientId;
    private Integer visitorId;
    private String patientName;
    private Integer gender;
    private Integer age;
    private String idNumber;
    private Integer unitId;
    private Integer doctorId;
    private Integer insuranceStatus;
    private Date inTime;
    private Date outTime;
    private Integer clinicDiagnosisId;
    private Integer admissionDiagnosisId;
    private Integer dischargeDiagnosisId;
    private Integer locationId;
    private DateTime paidTime;
    private Integer stayStatus;
    private Integer paymentStatus;
}
