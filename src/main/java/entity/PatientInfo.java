package entity;

import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
