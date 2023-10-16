package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MenuMapper {
    @Select("select * from menu where isdelete = 0")
    List<Menu> getAllMenus();

    @Select("select menu_id from menu where isdelete = 0")
    List<Integer> getAllMenuId();
    @Update("update menu set isdelete = 1 where menu_id = #{menuId}")
    void removeByMenuId(int menuId);
}
