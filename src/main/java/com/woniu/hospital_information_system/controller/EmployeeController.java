package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.Employee;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.Unit;
import com.woniu.hospital_information_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/getEmployee")
    /*
    通过科室id查出员工（医生）的姓名
    **/
    public ResponseEntity getEmployeeByUnitId(@RequestBody Unit unit){
        List<Employee> employeeByUnitId = employeeService.getEmployeeByUnitId(unit);
        return new ResponseEntity(200,"查询成功",employeeByUnitId);
    }
}
