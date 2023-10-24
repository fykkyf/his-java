package com.woniu.hospital_information_system.entity;

import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
* 门诊患者费用表
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorBill {
    private Integer visitorBillId;
    private Integer visitorId;
    private Integer treatmentId;
    private Integer drugCount;
    private Double treatmentPrice;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime paymentDate;
    private Integer paymentStatus;
    private Integer manipulateStatus;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dispenseTime;
}
