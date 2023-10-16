package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//员工职位表
public class EmployeeRole {
    private Integer employeeRoleId;
    private Integer employeeId;
    private Integer roleId;
}
