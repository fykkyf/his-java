package com.woniu.hospital_information_system.entity.DTO;

import com.woniu.hospital_information_system.entity.Role;
import com.woniu.hospital_information_system.entity.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private Integer employeeId;
    private String employeeName;
    private Role role;
    private Unit unit;
}
