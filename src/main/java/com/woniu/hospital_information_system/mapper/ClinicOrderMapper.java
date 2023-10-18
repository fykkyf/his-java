package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.ClinicOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClinicOrderMapper {
    @Insert("insert into clinic_order values (null,#{visitorId},#{doctorId},#{treatmentId},#{treatmentName},#{administrationId},#{dosageId},#{treatmentCount},now(),null)")
    void addClinicOrder(ClinicOrder clinicOrder);
    @Select("select treatment_price from treatment where treatment_id=#{treatmentId};")
    Double getPriceByTreatmentId(ClinicOrder clinicOrder);

    @Insert("insert into clinic_lab values (null,#{visitor_id},#{treatment_id},null,now(),1,null)")
//下医嘱时，如果需要进行检验，则在门诊检验表中生成数据
    void addClinicLab(ClinicOrder clinicOrder);

    @Insert("insert into clinic_raidology values (null,#{visitor_id},#{treatment_id},null,now(),1,null)")
//下医嘱时，如果需要进行检查，则在门诊检查表中生成数据
    void addClinicRaidology(ClinicOrder clinicOrder);
}
