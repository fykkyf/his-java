package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.PatientBill;
import com.woniu.hospital_information_system.entity.VO.PatientBillVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PatientBillMapper {
    //添加出院费用
    @Insert("insert into patient_bill values (null,#{patientId},7,null,0,null,null,1,1,null)")
    void dischargePatient(int patientId);
    //出院办理---修改操作状态
    @Update("update patient_bill set manipulate_status = 2 where patient_id = #{patientId} and treatment_id = 7 and  DATE(order_date) = CURDATE()")
    void completeDischarge(PatientInfoDTO patientInfoDTO);
    //添加住院费用明细
    @Insert("insert into patient_bill values (null,#{patientId},#{treatmentId},#{drugCount},#{treatmentPrice},now(),null,2,1,null)")
    void insertPatientBill(PatientBill patientBill);
    @Select("select * from patient_bill where patient_id = #{patientId}")
    List<PatientBill> getPatientBillByPatientId(Integer patientId);
    List<PatientBillVO> getPatientBillVO(Integer patientId);
    @Update("update patient_bill set payment_status = 3,payment_date = now() where patient_bill_id = #{patientBillId}")
    void billPaymentStatus(Integer patientBillId);
    @Select("select patient_bill_id from  patient_bill where patient_id = #{patientId} ")
    List<Integer> getAllBillIds(Integer patientId);
    //住院医嘱护士审核----修改记账状态
    @Update("update patient_bill set payment_status = 2,order_date = now() where patient_id = #{patientId} and payment_status = 1 and treatment_id = #{treatmentId}")
    void updatePatientBillByPaymentStatus(PatientBill patientBill);
}
