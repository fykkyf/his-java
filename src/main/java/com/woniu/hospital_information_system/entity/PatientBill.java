package com.woniu.hospital_information_system.entity;


import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
//住院患者费用表
public class PatientBill {

    private Integer patientBillId;
    private Integer patientId;
    private Integer treatmentId;
    private Integer drugCount;
    private Double treatmentPrice;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime paymentDate;
    private Integer paymentStatus;
    private Integer manipulateStatus;
}
