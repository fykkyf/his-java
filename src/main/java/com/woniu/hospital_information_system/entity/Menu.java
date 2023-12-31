package com.woniu.hospital_information_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
//菜单表
public class Menu {
    private Integer menuId;
    private String menuName;
    private String path;
    private Integer pmenuId;
    private List<Menu> children = new ArrayList<>();
}
