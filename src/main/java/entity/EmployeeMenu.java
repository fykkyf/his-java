package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//员工菜单表
public class EmployeeMenu {
    private Integer employeeMenuId;
    private Integer menuId;
    private Integer roleId;
}
