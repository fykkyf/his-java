package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.Unit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UnitMapper {

    @Select("select * from unit")
    List<Unit> getAllUnits();
}
