package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.Dosage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DosageMapper {
    @Select("select * from dosage")
    List<Dosage> selectDosages();
}
