package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.DTO.PatientRaidologyDTO;
import com.woniu.hospital_information_system.entity.PatientRaidology;
import com.woniu.hospital_information_system.entity.VO.PatientRaidologyVO;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PatientRaidologyMapper {

    @Update("update patient_raidology set path=#{path},file_name=#{fileName},test_date = now() where patient_raidology_id=#{patientRaidologyId}")
    void addPicture(@Param("path") String path,@Param("fileName") String fileName,@Param("patientRaidologyId") Integer patientRaidologyId);

    @Select("select fileName from patient_raidology where visitor_id=#{visitorId}")
    String getPictureFileName(VisitorInfo visitorInfo);
    @Insert("insert into patient_raidology values(null,#{patientId},#{treatmentId},null,null,1,null)")
    void insertPatientRaidology(@Param("patientId") Integer patientId, @Param("treatmentId")Integer treatmentId);

    List<PatientRaidologyVO> selectAllPatientRaido();

    List<PatientRaidologyVO> selectPatientRaidosByKeyWord(PatientRaidologyDTO PatientRaidologyDTO);
}
