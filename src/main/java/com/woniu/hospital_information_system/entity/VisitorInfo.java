package com.woniu.hospital_information_system.entity;

import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
/*
* 门诊患者信息表
* */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitorInfo {
    private Integer visitorId;
    private String visitorName;
    private Integer gender;
    private Integer age;
    private String idNumber;
    private BigInteger phone;
    private Integer unitId;
    private Integer doctorId;
    private Integer diseaseId;
    private DateTime clinicStartTime;
    private Integer clinicStatus;
}
