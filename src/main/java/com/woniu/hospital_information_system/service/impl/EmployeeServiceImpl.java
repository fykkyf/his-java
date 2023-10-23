package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.Employee;
import com.woniu.hospital_information_system.entity.Unit;
import com.woniu.hospital_information_system.entity.VO.EmployeeVO;
import com.woniu.hospital_information_system.mapper.EmployeeMapper;
import com.woniu.hospital_information_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getEmployeeByUnitId(Unit unit) {
        return employeeMapper.getEmployeeByUnitId(unit);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeMapper.getAllEmployees();
    }

    @Override
    public Unit getUnitByDoctorId(Integer doctorId) {
        return employeeMapper.selectUnitByDoctorId(doctorId);
    }

    @Override
    public List<EmployeeVO> getAllVO() {
        return employeeMapper.getAllVO();
    }
}
