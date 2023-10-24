package com.woniu.hospital_information_system.mapper;


import com.woniu.hospital_information_system.entity.Dosage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DosageMapper {
    @Select("select * from dosage")
    List<Dosage> selectDosages();

    @Insert("insert into dosage values (null,#{dosageName})")
    void addDosage(Dosage dosage);
    @Update("update dosage set dosage_name = #{dosageName} where dosage_id = #{dosageId}")
    void updateDosage(Dosage dosage);
    @Delete("delete from dosage where dosage_id = #{dosageId}")
    void deleteDosage(int dosageId);


    @Select("select dosage_name from dosage where dosage_id=#{dosageId}")
    String getById(Integer dosageId);
}
