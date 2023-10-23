package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.Disease;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DiseaseMapper {
    @Select("select * from disease where disease_id = #{diseaseId}")
    Disease selectDiseaseById(int diseaseId);
    @Select("select * from disease")
    List<Disease> selectAllDisease();
}
