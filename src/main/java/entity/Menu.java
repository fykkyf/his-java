package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Menu {
    private Integer menuId;
    private String menuName;
    private String path;
    private Integer pmenuId;
}
