package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.Location;
import org.apache.ibatis.annotations.*;

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
    @Update("update location set location_status = 2 where location_id = #{locationId}")
    void updateLocationStatus(int locationId);
    //清空床位
    @Update("update location set location_status = 1 where location_id = #{locationId}")
    void updateLocationStatusEmpty(Integer locationId);

    @Update("update location set location_name = #{locationName} where location_id = #{locationId}")
    void updateLocation(Location location);
    @Delete("delete from location where location_id = #{locationId}")
    void removeLocation(Integer locationId);
    @Insert("insert into location values (null,#{locationName},0)")
    void addNewlocation(Location location);
}
