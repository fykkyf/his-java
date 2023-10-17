package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.ClinicOrder;
import com.woniu.hospital_information_system.entity.Treatment;
import com.woniu.hospital_information_system.entity.VisitorBill;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface VisitorBillMapper {

    @Insert("insert into visitor_bill values (null,#{visitorId},#{treatmentId},null,#{treatmentPrice},#{orderDate},null,1,0)")
    void addVisitorBill(@Param("visitorId") Integer visitorId, @Param("treatmentId") Integer treatmentId, @Param("treatmentPrice") Double treatmentPrice,@Param("orderDate") Timestamp orderDate);

    @Select("select treatment_id from employee_role er,employee e,role r where er.employee_id=e.employee_id and er.role_id=r.role_id and e.employee_id = #{employeeId}")
    Integer getTreatmentId(Integer employeeId);

    @Select("select treatment_price from treatment where treatment_id=#{treatmentId}")
    Double getPriceByTreatmentId(Integer treatmentId);

    @Update("update visitor_bill set payment_date = now(), payment_status=2,manipulate_status=1 where visitor_id = #{visitorId} ")
    void updatePayStatus(Integer visitorId);

    @Select("select treatment_price from treatment where treatment_id=#{treatmentId}")
    Integer getTreatmentCategoryByTreatmentId (ClinicOrder clinicOrder);//通过tid查出金额

    @Select("select * from visitor_bill where visitor_id = #{visitorId} and payment_status=#{paymentStatus} and manipulate_status = #{manipulateStatus}")
    List<VisitorBill> getAllBillsByVisitorId(Integer visitorId);
    @Update("update visitor_bill set payment_status = 2, payment_date = now() where visitor_bill_id = #{visitorBillId}")
    void changePaymentStatus(Integer visitorBillId);
}
