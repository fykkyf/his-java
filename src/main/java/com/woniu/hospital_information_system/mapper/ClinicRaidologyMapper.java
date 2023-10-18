package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.VisitorInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ClinicRaidologyMapper {

    @Update("update clinic_raidology set path=#{path},fileName=#{fileName} where clinic_raidology_id=#{clinicRaidologyId}")
    void addPicture(@Param("path") String path,@Param("fileName") String fileName,@Param("clinicRaidologyId") Integer clinicRaidologyId);

    @Select("select fileName from clinic_raidology where visitor_id=#{visitorId}")
    String getPictureFileName(VisitorInfo visitorInfo);
}
