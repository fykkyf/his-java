package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeMenu {
    private Integer employeeMenuId;
    private Integer menuId;
    private Integer roleId;
}
