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

    @Update("update visitor_info set clinic_status=3 where visitor_id=#{visitorId}")
//医生点击诊断的确定后，修改病人疾病id
    void updateClinicStatusAfterVisiting(VisitorInfo visitorInfo);

    @Update("update visitor_info set disease_id=#{diseaseId} where visitor_id=#{visitorId}")
//病人在门诊看病的整个业务流程走完后，自己的信息后有一个确定按钮，点击确定，状态为过诊
    void updateDisease(VisitorInfo visitorInfo);

    @Select("select * from visitor_info")
    List<VisitorInfo> getAll();

    @Select("select * from visitor_info where doctor_id=#{eid} and clinic_status=1")
    List<VisitorInfo> getVisitorByEmployeeId(Integer eid);
}
