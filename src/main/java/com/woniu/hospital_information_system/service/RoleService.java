package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.DTO.RoleMenuDTO;
import com.woniu.hospital_information_system.entity.Role;

import java.util.List;

public interface RoleService {

    void giveMenu(RoleMenuDTO roleMenuDTO);

    List<Role> getAllRoles();

    void removeByRoleId(int roleId);
}
