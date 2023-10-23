package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.Location;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface LocationMapper {
    //查询所有床位信息
    @Select("select * from location")
    List<Location> selectLocations();
    //根据床位状态查询床位信息
    @Select("select * from location where location_status = #{status}")
    List<Location> selectLocationsByStatus(int status);
    //添加床位
    @Update("update location set location_status = 1 where location_id = #{locationId}")
    void updateLocationStatus(int locationId);
    //清空床位
    @Update("update location set location_status = 0 where location_id = #{locationId}")
    void updateLocationStatusEmpty(Integer locationId);


}
