package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.DTO.MenuDTO;
import com.woniu.hospital_information_system.entity.Menu;
import com.woniu.hospital_information_system.mapper.MenuMapper;
import com.woniu.hospital_information_system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Override
    public List<Menu> getAllMenus() {

        List<Menu> allMenus = menuMapper.getAllMenus();
        List<Menu> menus = new ArrayList<>();
        for (Menu menu : allMenus){
            if(menu.getPmenuId().equals(0)){
                menus.add(menu);
                for (Menu child : allMenus){
                    if(child.getPmenuId().equals(menu.getMenuId())){
                        menu.getChildren().add(child);
                    }
                }
            }
        }
        return  menus;
//        return  menuMapper.getAllMenus();
    }

    @Override
    public void removeByMenuId(int menuId) {
        menuMapper.removeByMenuId(menuId);
    }

    @Override
    public boolean checkExist(Integer menuId) {
        Menu menu = menuMapper.checkExist(menuId);
        if(menu == null){
            return false;
        }else {
            return true;
        }

    }

    @Override
    public void update(MenuDTO menuDTO) {
        menuMapper.update(menuDTO);
    }

    @Override
    public void add(MenuDTO menuDTO) {
        menuMapper.add(menuDTO);
    }
}
