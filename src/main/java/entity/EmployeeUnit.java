package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//员工科室表
public class EmployeeUnit {
    private Integer employeeUnitId;
    private Integer employeeId;
    private Integer unitId;
}
