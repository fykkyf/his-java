package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.DTO.MenuDTO;
import com.woniu.hospital_information_system.entity.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MenuMapper {
    @Select("select * from menu where isdelete = 0")
    List<Menu> getAllMenus();

    @Select("select menu_id from menu where isdelete = 0")
    List<Integer> getAllMenuId();
    @Update("update menu set isdelete = 1 where menu_id = #{menuId}")
    void removeByMenuId(int menuId);
    @Select("select * from menu where isdelete = 0 and menu_id = #{menuId}")
    Menu checkExist(Integer menuId);
    @Update("update menu set menu_name = #{menuName}, path = #{path} where menu_id = #{menuId} and isdelete = 0")
    void update(MenuDTO menuDTO);
    @Insert("insert into menu values(null,#{menuName},#{path},#{pmenuId},0) ")
    void add(MenuDTO menuDTO);
    @Delete("delete from employee_menu where role_id = #{roleId} ")
    void removeMenuByRoleId(int roleId);
}
