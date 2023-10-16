package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.DTO.MenuDTO;
import com.woniu.hospital_information_system.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getAllMenus();

    void removeByMenuId(int menuId);

    boolean checkExist(Integer menuId);

    void update(MenuDTO menuDTO);

    void add(MenuDTO menuDTO);
}
