package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.Administration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdministrationMapper {
    @Select("select * from administration")
    List<Administration> selectAdministrations();
}
