package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.DTO.EmployeeDTO;
import com.woniu.hospital_information_system.entity.Employee;
import com.woniu.hospital_information_system.entity.Role;
import com.woniu.hospital_information_system.entity.Unit;
import com.woniu.hospital_information_system.entity.VO.EmployeeVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    List<Employee> getEmployeeByUnitId(Unit unit);

    @Select("select * from employee ")
    List<Employee> getAllEmployees();
    @Select("select * from employee where employee_id = #{employeeId}")
    Employee selectEmployeeById(Integer employeeId);
    //获取所有医生信息
    List<Employee> selectEmployee();
    //根据医生id查询科室
    Unit selectUnitByDoctorId(Integer doctorId);

    List<EmployeeVO> getAllVO();

    void addNewEmployee(EmployeeDTO employeeDTO);

    void addNewEmployeeRole(@Param("employeeId")Integer employeeId,@Param("roleId")Integer roleId);

    void addNewEmployeeUnit(@Param("employeeId")Integer employeeId,@Param("unitId") Integer unitId);

    void updateEmployeeDTO(EmployeeDTO employeeDTO);

    void updateEmployeeRole(@Param("employeeId") Integer employeeId, @Param("roleId") Integer roleId);

    void updateEmployeeUnit(@Param("employeeId") Integer employeeId, @Param("unitId") Integer unitId);

    void removeEmployee(Integer employeeId);

    void removeEmployeeRole(Integer employeeId);

    void removeEmployeeUnit(Integer employeeId);
}
