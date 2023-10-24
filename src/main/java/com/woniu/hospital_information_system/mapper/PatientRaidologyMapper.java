package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.VisitorInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PatientRaidologyMapper {

    @Update("update patient_raidology set path=#{path},fileName=#{fileName} where patient_raidology_id=#{patientRaidologyId}")
    void addPicture(@Param("path") String path,@Param("fileName") String fileName,@Param("patientRaidologyId") Integer patientRaidologyId);

    @Select("select fileName from patient_raidology where visitor_id=#{visitorId}")
    String getPictureFileName(VisitorInfo visitorInfo);
    @Insert("insert into patient_raidology values(null,#{patientId}),#{treatmentId},null,null,1,null")
    void insertPatientRaidology(@Param("patientId") Integer patientId, @Param("treatmentId")Integer treatmentId);
}
