package com.woniu.hospital_information_system.mapper;


import com.woniu.hospital_information_system.entity.VisitorInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

@Mapper
public interface VisitorInfoMapper {

//    @Insert("insert into visitor_info values (null,#{visitorName},#{gender},#{idNumber},#{phone},#{unitId},#{doctorId},null,#{clinicStartTime},1)")
    void addVisitorInfo(VisitorInfo visitorInfo);

    @Select("select * from visitor_info where visitor_id=#{visitorId}")
    VisitorInfo getVisitorInfoByVisitorId(Integer visitorId);


    List<VisitorInfo> getVisitorInfoByPaySuccess();


    @Update("update visitor_info set clinic_status=2 where visitor_id=#{visitorId}")
    void updateClinicStatus(Integer visitorId);

    @Select("select * from visitor_info")
    VisitorInfo getVisitingByVisitorId(Integer visitorId);

    @Update("update visitor_info set clinic_status=3,disease_id=#{diseaseId} where visitor_id=#{visitorId}")
    void updateClinicStatusAndDisease(VisitorInfo visitorInfo);
}
