package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.ClinicOrder;
import com.woniu.hospital_information_system.entity.DTO.ClinicOrderDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClinicOrderMapper {
    @Insert("insert into clinic_order values (null,#{visitorId},#{doctorId},#{treatmentId},#{treatmentName},#{administrationId},#{dosageId},#{treatmentCount},now(),null)")
    void addClinicOrder(ClinicOrderDTO clinicOrderDTO);
    @Select("select treatment_price from treatment where treatment_id=#{treatmentId};")
    Double getPriceByTreatmentId(ClinicOrderDTO clinicOrderDTO);

    @Insert("insert into clinic_lab values (null,#{visitor_id},#{treatment_id},null,now(),1,null)")
//下医嘱时，如果需要进行检验，则在门诊检验表中生成数据
    void addClinicLab(ClinicOrderDTO clinicOrderDTO);

    @Insert("insert into clinic_raidology values (null,#{visitor_id},#{treatment_id},null,now(),1,null)")
//下医嘱时，如果需要进行检查，则在门诊检查表中生成数据
    void addClinicRaidology(ClinicOrderDTO clinicOrderDTO);
}
