package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.InsuranceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface InsuranceInfoMapper {
    @Select("select * from insurance where id_number = #{idNumber}")
    InsuranceInfo selectInsuranceInfoByIdNumber(String idNumber);
}
