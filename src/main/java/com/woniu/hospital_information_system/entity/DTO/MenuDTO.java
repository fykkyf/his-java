package com.woniu.hospital_information_system.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
//菜单表
public class MenuDTO {
    private Integer menuId;
    private String menuName;
    private String path;
    private Integer pmenuId;

}