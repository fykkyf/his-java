package com.woniu.hospital_information_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//医保信息表
public class InsuranceInfo {
    private Integer insuranceId;
    private String idNumber;
}
