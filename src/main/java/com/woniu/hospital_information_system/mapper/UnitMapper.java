package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.Unit;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UnitMapper {

    @Select("select * from unit")
    List<Unit> getAllUnits();
    @Insert("insert into unit values(null,#{unitName})")
    void add(Unit unit);
    @Update("update unit set unit_name = #{unitName} where unit_id = #{unitId}")
    void update(Unit unit);
    @Delete("delete from unit where unit_id = #{unitId}")
    void remove(int unitId);
}
