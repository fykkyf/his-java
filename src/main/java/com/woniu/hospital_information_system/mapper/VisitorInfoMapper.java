package com.woniu.hospital_information_system.mapper;


import com.woniu.hospital_information_system.entity.VisitorInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface VisitorInfoMapper {

    @Insert("insert into visitor_info values (null,#{visitorName},#{gender},#{idNumber},#{phone},#{unitId},#{doctorId},null,#{clinicStartTime},1)")
    void addVisitorInfo(VisitorInfo visitorInfo);

    @Select("select * from visitor_info where visitor_id=#{visitorId}")
    VisitorInfo getVisitorInfoByVisitorId(Integer visitorId);
}
