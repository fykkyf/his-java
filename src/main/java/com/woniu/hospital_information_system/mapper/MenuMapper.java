package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper {
    @Select("select * from menu where isdelete = 0")
    public List<Menu> getAllMenus();
}
