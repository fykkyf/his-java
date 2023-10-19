package com.woniu.hospital_information_system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
//住院患者信息表
public class PatientInfo {
    private Integer patientId;
    private Integer visitorId;
    private String patientName;
    private Integer gender;
    private Integer age;
    private String idNumber;
    private Unit unit;
    private Employee employee;
    private Integer insuranceStatus;
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss")
    private LocalDateTime inTime;
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss")
    private LocalDateTime outTime;
    private Disease clinicDiagnosis;//门诊疾病
    private Disease admissionDiagnosis;//入院诊断
    private Disease dischargeDiagnosis;//出院诊断
    private Integer locationId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime paidTime;
    private Integer stayStatus;
    private Integer paymentStatus;
}
