package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.ClinicRaidology;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClinicRaidologyMapper {

    @Update("update clinic_raidology set test_status=2,path=#{path},file_name=#{fileName},test_date=now() where clinic_raidology_id=#{clinicRaidologyId}")
    void addPicture(@Param("path") String path,@Param("fileName") String fileName,@Param("clinicRaidologyId") Integer clinicRaidologyId);

    @Select("select file_name from clinic_raidology where visitor_id=#{visitorId}")
    String getPictureFileName(Integer visitorId);

    @Select("select * from clinic_raidology where test_status=1")
    List<ClinicRaidology> getNoCheck();
}
