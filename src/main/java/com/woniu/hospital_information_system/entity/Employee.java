package com.woniu.hospital_information_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//员工表
public class Employee {
    private Integer employeeId;
    private String employeeName;
}
