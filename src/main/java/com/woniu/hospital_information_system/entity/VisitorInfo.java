package com.woniu.hospital_information_system.entity;

import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

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
    private String idNumber;
    private Integer phone;
    private Integer unitId;
    private Integer doctorId;
    private Integer diseaseId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime clinicStartTime;
    private Integer clinicStatus;
}
