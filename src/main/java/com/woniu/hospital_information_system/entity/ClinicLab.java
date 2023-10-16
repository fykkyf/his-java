package com.woniu.hospital_information_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
//门诊检验表
public class ClinicLab {
    private Integer clinicLabId;
    private Integer visitorId;
    private Integer treatmentId;
    private String labResult;
    private Date testDate;
    private Integer testStatus;
}