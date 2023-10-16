package com.woniu.hospital_information_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//用法表
public class Administration {
    //用法ID
    private Integer administrationId;
    //用法名称
    private String administrationName;
}
