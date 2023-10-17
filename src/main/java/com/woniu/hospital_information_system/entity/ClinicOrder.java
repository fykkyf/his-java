package com.woniu.hospital_information_system.entity;

import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
* 门诊医嘱表
* */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClinicOrder {
    private Integer clinicOrderId;
    private Integer visitorId;
    private Integer doctorId;
    private Integer treatmentId;
    private String treatmentName;
    private Integer administrationId;
    private Integer dosageId;
    private Integer treatmentCount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime executionTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dispenseTime;
}
