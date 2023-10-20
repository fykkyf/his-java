package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.Employee;
import com.woniu.hospital_information_system.entity.Unit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    List<Employee> getEmployeeByUnitId(Unit unit);
    @Select("select * from employee where employee_id = #{employeeId}")
    Employee selectEmployeeById(Integer employeeId);
    //获取所有医生信息
    List<Employee> selectEmployee();
}
