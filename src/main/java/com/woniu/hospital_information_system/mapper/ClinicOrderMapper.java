package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.ClinicOrder;
import com.woniu.hospital_information_system.entity.DTO.ClinicOrderDTO;
import com.woniu.hospital_information_system.entity.VO.ClinicOrderVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClinicOrderMapper {
    @Insert("insert into clinic_order values (null,#{visitorId},#{doctorId},#{treatment.treatmentId},#{treatmentName},#{administrationId},#{dosageId},#{treatmentCount},now(),null)")
    void addClinicOrder(ClinicOrderDTO clinicOrderDTO);
    @Select("select treatment_price from treatment where treatment_id=#{treatment.treatmentId};")
    Double getPriceByTreatmentId(ClinicOrderDTO clinicOrderDTO);

    @Insert("insert into clinic_lab values (null,#{visitorId},#{treatment.treatmentId},null,null,1)")
//下医嘱时，如果需要进行检验，则在门诊检验表中生成数据
    void addClinicLab(ClinicOrderDTO clinicOrderDTO);

    @Insert("insert into clinic_raidology values (null,#{visitorId},#{treatment.treatmentId},null,null,1,null)")
//下医嘱时，如果需要进行检查，则在门诊检查表中生成数据
    void addClinicRaidology(ClinicOrderDTO clinicOrderDTO);


//    @Select("select * from clinic_order where visitor_id=#{visitorId}")
    List<ClinicOrderVO> getOrderByVisitorId(Integer visitorId);
}
