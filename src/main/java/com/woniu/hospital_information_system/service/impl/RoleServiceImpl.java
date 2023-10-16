package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.mapper.MenuMapper;
import com.woniu.hospital_information_system.mapper.RoleMapper;
import com.woniu.hospital_information_system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    RoleMapper roleMapper;

    @Override
    public void giveMenu() {
        for(Integer menuId : menuMapper.getAllMenuId()){
            roleMapper.insertMenusByRid(1,menuId);
        }
    }
}
