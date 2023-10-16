package com.woniu.hospital_information_system.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RoleMapper {
    @Insert("insert into employee_menu values(null,#{roleId},#{menuId})")
    void insertMenusByRid(@Param("roleId") Integer roleId, @Param("menuId") Integer menuId);
}
