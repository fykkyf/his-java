package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.DTO.RoleMenuDTO;
import com.woniu.hospital_information_system.entity.Role;
import com.woniu.hospital_information_system.mapper.MenuMapper;
import com.woniu.hospital_information_system.mapper.RoleMapper;
import com.woniu.hospital_information_system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    RoleMapper roleMapper;

    @Override
    public void giveMenu(RoleMenuDTO roleMenuDTO) {
        menuMapper.removeMenuByRoleId(roleMenuDTO.getRole().getRoleId());
        for(Integer menuId : roleMenuDTO.getMenuIds()){
            roleMapper.insertMenusByRid(roleMenuDTO.getRole().getRoleId(),menuId);
        }
    }

    @Override
    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    @Override
    @Transactional
    public void removeByRoleId(int roleId) {
        roleMapper.removeByRoleId(roleId);
        menuMapper.removeMenuByRoleId(roleId);
    }

    @Override
    public void add(Role role) {
        roleMapper.add(role);
    }
}
