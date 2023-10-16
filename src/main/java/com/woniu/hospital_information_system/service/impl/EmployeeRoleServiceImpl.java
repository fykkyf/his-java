package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.mapper.EmployeeRoleMapper;
import com.woniu.hospital_information_system.service.EmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRoleServiceImpl implements EmployeeRoleService {
    @Autowired
    EmployeeRoleMapper employeeRoleMapper;
}
