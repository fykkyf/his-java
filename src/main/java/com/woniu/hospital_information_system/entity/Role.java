package com.woniu.hospital_information_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//职位表
public class Role {
    private Integer roleId;
    private String roleName;
    private Integer treatmentId;
}
