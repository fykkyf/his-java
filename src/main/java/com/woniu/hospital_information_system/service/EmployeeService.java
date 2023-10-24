package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.DTO.EmployeeDTO;
import com.woniu.hospital_information_system.entity.Employee;
import com.woniu.hospital_information_system.entity.Unit;
import com.woniu.hospital_information_system.entity.VO.EmployeeVO;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeByUnitId(Unit unit);

    List<Employee> getAllEmployees();
    //根据医生id查询科室
    Unit getUnitByDoctorId(Integer doctorId);

    List<EmployeeVO> getAllVO();

    void addNewEmployee(EmployeeDTO employeeDTO);

    void updateEmployeeDTO(EmployeeDTO employeeDTO);

    void removeEmployee(Integer employeeId);
}
