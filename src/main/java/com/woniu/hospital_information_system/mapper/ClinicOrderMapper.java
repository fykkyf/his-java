package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.ClinicOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClinicOrderMapper {
    @Insert("insert into clinic_order values (null,#{visitorId},#{doctorId},#{treatmentId},#{treatmentName},#{administrationId},#{dosageId},#{treatmentCount},now(),null)")
    void addClinicOrder(ClinicOrder clinicOrder);
}
