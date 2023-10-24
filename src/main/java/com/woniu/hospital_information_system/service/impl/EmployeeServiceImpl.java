package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.DTO.EmployeeDTO;
import com.woniu.hospital_information_system.entity.Employee;
import com.woniu.hospital_information_system.entity.Unit;
import com.woniu.hospital_information_system.entity.VO.EmployeeVO;
import com.woniu.hospital_information_system.mapper.EmployeeMapper;
import com.woniu.hospital_information_system.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
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

    @Override
    @Transactional
    @Options(useGeneratedKeys = true,keyColumn = "employee_id",keyProperty = "employeeId")
    public void addNewEmployee(EmployeeDTO employeeDTO) {
        employeeMapper.addNewEmployee(employeeDTO);
        employeeMapper.addNewEmployeeRole(employeeDTO.getEmployeeId(),employeeDTO.getRoleId());
        employeeMapper.addNewEmployeeUnit(employeeDTO.getEmployeeId(),employeeDTO.getUnitId());

    }

    @Override
    @Transactional
    public void updateEmployeeDTO(EmployeeDTO employeeDTO) {
        employeeMapper.updateEmployeeDTO(employeeDTO);
        log.info("eid = "+employeeDTO.getEmployeeId());

        employeeMapper.updateEmployeeRole(employeeDTO.getEmployeeId(),employeeDTO.getRoleId());
        employeeMapper.updateEmployeeUnit(employeeDTO.getEmployeeId(),employeeDTO.getUnitId());
    }

    @Override
    @Transactional
    public void removeEmployee(Integer employeeId) {
        employeeMapper.removeEmployee(employeeId);
        employeeMapper.removeEmployeeRole(employeeId);
        employeeMapper.removeEmployeeUnit(employeeId);
    }
}
