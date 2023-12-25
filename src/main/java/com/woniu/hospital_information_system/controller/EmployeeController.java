package com.woniu.hospital_information_system.controller;

import com.woniu.hospital_information_system.entity.DTO.EmployeeDTO;
import com.woniu.hospital_information_system.entity.Employee;
import com.woniu.hospital_information_system.entity.ResponseEntity;
import com.woniu.hospital_information_system.entity.Unit;
import com.woniu.hospital_information_system.entity.VO.EmployeeVO;
import com.woniu.hospital_information_system.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
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

    @GetMapping("/getAllEmployee")
    /*
    通过科室id查出员工（医生）的姓名
    **/
    public ResponseEntity getAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return new ResponseEntity(200,"查询成功",allEmployees);
    }

    /*
    *   根据医生id查询科室信息
    * */
    @GetMapping("/getUnitByDid/{doctorId}")
    public Object getUnitByDoctorId(@PathVariable("doctorId") Integer doctorId) {
        return new ResponseEntity(200,"request success",employeeService.getUnitByDoctorId(doctorId));
    }
    @GetMapping("/getAllVO")
    public Object getAllVO(){
        return new ResponseEntity(200,"success",employeeService.getAllVO());
    }
    @PostMapping("/updateEmployee")
    public Object addNewEmployee(@RequestBody EmployeeVO employeeVO){

        if(employeeVO.getEmployeeId()==null){
            employeeService.addNewEmployee(employeeVO);
            return new ResponseEntity(201,"添加成功",null);
        }else {
            log.info(employeeVO.toString());
            employeeService.updateEmployeeDTO(employeeVO);
            return new ResponseEntity(202,"修改成功",null);
        }

    }
    @PostMapping("/removeEmployeeVO/{employeeId}")
    public ResponseEntity removeEmployee(@PathVariable Integer employeeId){
        employeeService.removeEmployee(employeeId);
        return new ResponseEntity(200,"success",null);
    }

}
