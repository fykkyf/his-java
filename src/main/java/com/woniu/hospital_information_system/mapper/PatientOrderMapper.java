package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.DTO.PatientOrderDTO;
import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.entity.PatientOrder;
import com.woniu.hospital_information_system.entity.VO.PatientBillVO;
import com.woniu.hospital_information_system.entity.VO.PatientDailyOrderVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PatientOrderMapper {
    //获取所有住院医嘱信息
//    @Select("select * from patient_order")
    List<PatientOrder> selectAllPatientOrders();
    //获取当天所有医嘱信息
    List<PatientBillVO> selectAllPatientOrdersByDaily(int patientId);
    List<PatientDailyOrderVO> selectAllPatientDailyOrder(int patientId);
    //给住院患者下医嘱
    void addPatientOrderByPatientOrderId(PatientOrder patientOrder);
    //根据住院患者id查询住院患者医嘱信息
//    @Select("select * from patient_order where patient_id = #{patientId}")
    List<PatientOrder> selectPatientOrderByPatientId(int patientId);
    //更改住院医嘱信息--执行状态
    @Update("update patient_order set execution_status = #{executionStatus} where patient_order_id = #{patientOrderId}")
    void updatePatientOrderStatusByPatientId(PatientOrder patientOrder);
    //更改住院医嘱信息--执行时间
    @Update("update patient_order set execution_time = now() where patient_order_id = #{patientOrderId}")
    void updatePatientOrderTimesByPatientId(PatientOrder patientOrder);
    //办理出院
    @Insert("insert into patient_order values (null,#{patientId},#{doctorId},7,'办理出院',null,null,null,null,null,1,1)")
    void dischargePatient(PatientInfoDTO patientInfoDTO);
    @Update("update patient_order set execution_status = #{executionStatus} where patient_id = #{patientId}")
    void checkDischarge(@Param("executionStatus")int executionStatus, @Param("patientId")int patientId);
    //通过医嘱类型和执行状态查询住院医嘱信息
//    @Select("select * from patient_order where execution_status = #{executionStatus} and order_type = #{orderType}")
    List<PatientOrder> selectPatientOrderByStatus(@Param("executionStatus")int executionStatus, @Param("orderType")int orderType);
    @Update("update patient_order set  execution_status = 4 where patient_id = #{patientId} ")
    void finishPayment(Integer patientId);
    //模糊查询住院患者医嘱信息
    List<PatientOrder> selectPatientOrderByKeyWord(PatientOrder patientOrder);
    List<PatientOrder> selectPatientOrderByKeyWordLong(PatientOrder patientOrder);

    //医生修改病人医嘱
    void updatePatientOrderByPatientId(PatientOrder patientOrder);
}
