package com.woniu.hospital_information_system.entity.VO;

import com.woniu.hospital_information_system.entity.Role;
import com.woniu.hospital_information_system.entity.Unit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeVO {
    private Integer employeeId;
    private String employeeName;
    private Role role;
    private Unit unit;
}
