package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.Administration;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdministrationMapper {
    @Select("select * from administration")
    List<Administration> selectAdministrations();
    @Insert("insert into administration values (null,#{administrationName})")
    void addAdministration(Administration administration);
    @Update("update administration set administration_name = #{administrationName} where administration_id = #{administrationId}")
    void updateAdministration(Administration administration);
    @Delete("delete from administration where administration_id = #{administrationId}")
    void deleteAdministration(int administrationId);

    @Select("select administration_name from administration where administration_id=#{administrationId}")
    String getById(Integer administrationId);
}
