package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.Menu;
import com.woniu.hospital_information_system.mapper.MenuMapper;
import com.woniu.hospital_information_system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }
}
