package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {
    @Insert("insert into employee_menu values(null,#{roleId},#{menuId})")
    void insertMenusByRid(@Param("roleId") Integer roleId, @Param("menuId") Integer menuId);
    @Select("select * from role where isdelete = 0")
    List<Role> getAllRoles();
    @Update("update role set isdelete = 1 where role_id = #{roleId}")
    void removeByRoleId(int roleId);
    @Insert("insert into role values (null,#{roleName},null)")
    void add(Role role);
    @Select("select menu_id from employee_menu where role_id = #{roleId}")
    List<Integer> selectMenuIdsByRoleId(int roleId);
}
