package com.woniu.hospital_information_system.mapper;


import com.woniu.hospital_information_system.entity.VisitorBill;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;

@Mapper
public interface VisitorInfoMapper {

//    @Insert("insert into visitor_info values (null,#{visitorName},#{gender},#{idNumber},#{phone},#{unitId},#{doctorId},null,#{clinicStartTime},1)")
    void addVisitorInfo(VisitorInfo visitorInfo);


    VisitorInfo getVisitorInfoByVisitorId(Integer visitorId);


    List<VisitorInfo> getVisitorInfoByPaySuccess();


    @Update("update visitor_info set clinic_status=2 where visitor_id=#{visitorId}")
    void updateClinicStatus(Integer visitorId);

    @Select("select * from visitor_info")
    VisitorInfo getVisitingByVisitorId(Integer visitorId);

    @Update("update visitor_info set clinic_status=3 where visitor_id=#{visitorId}")
//医生点击诊断的确定后，修改病人疾病id
    void updateClinicStatusAfterVisiting(VisitorInfo visitorInfo);

    @Update("update visitor_info set disease_id=#{diseaseId},clinic_status=3 where visitor_id=#{visitorId}")
//病人在门诊看病的整个业务流程走完后，自己的信息后有一个确定按钮，点击确定，状态为过诊
    void updateDisease(@Param("visitorId") Integer visitorId,@Param("diseaseId") Integer diseaseId);


    //根据身份证号码查询门诊信息
    @Select("select * from visitor_info where id_number = #{idNumber}")
    List<VisitorInfo> selectVisitorInfoByIdNumber(String idNumber);

    @Select("select * from visitor_info where doctor_id=#{eid} and clinic_status=1")
    List<VisitorInfo> getVisitorByEmployeeId(Integer eid);

    @Update("update visitor_info set visitor_name=#{visitorName},gender=#{gender},age=#{age},id_number=#{idNumber},phone=#{phone},unit_id=#{unitId},doctor_id=#{doctorId}")
    void updateMessage(VisitorInfo visitorInfo);


    @Select("select * from visitor_bill where payment_status=2 and manipulate_status=1 and treatment_id = #{treatmentId}")
    List<VisitorBill> getVisitorInfoIdByPaySuccessAndManipulateStatus(Integer treatmentId);

    @Select("select * from visitor_info where visitor_id=#{visitorId}")
    List<VisitorInfo> getVisByVid(Integer visitorId);

    List<VisitorInfo> getByCondition(VisitorInfo visitorInfo);


    @Update("update visitor_info set unit_id=#{unitId} , doctor_id=#{employeeId} where visitor_id = #{visitorId}")
    void updateDoc(@Param("visitorId") Integer visitorId,@Param("employeeId") Integer employeeId,@Param("unitId") Integer unitId);
}
