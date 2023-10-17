package com.woniu.hospital_information_system.service.impl;

import cn.hutool.core.date.DateTime;
import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.DTO.PatientOrderDTO;
import com.woniu.hospital_information_system.entity.DTO.TreatmentDTO;
import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.entity.PatientOrder;
import com.woniu.hospital_information_system.entity.Treatment;
import com.woniu.hospital_information_system.mapper.PatientBillMapper;
import com.woniu.hospital_information_system.mapper.PatientOrderMapper;
import com.woniu.hospital_information_system.service.PatientInfoService;
import com.woniu.hospital_information_system.service.PatientOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class PatientOrderServiceImpl implements PatientOrderService {
    @Autowired
    PatientOrderMapper patientOrderMapper;
    @Autowired
    PatientBillMapper patientBillMapper;

    /*
     * 获取所有住院患者医嘱信息
     * */
    @Override
    public List<PatientOrder> getAllPatientOrders() {
        return patientOrderMapper.selectAllPatientOrders();
    }

    /*
     * 医生给住院患者下医嘱
     * */
    @Override
    public void addPatientOrder(PatientOrderDTO patientOrderDTO) {
        for (TreatmentDTO treatment : patientOrderDTO.getTreatments()) {
            PatientOrder patientOrder = getPatientOrder(patientOrderDTO, treatment);
            patientOrderMapper.addPatientOrderByPatientOrderId(patientOrder);
        }
    }

    /*
     * 根据患者id查询住院医嘱信息
     * */
    @Override
    public PatientOrder getPatientOrderByPatientId(int patientId) {
        return patientOrderMapper.selectPatientOrderByPatientId(patientId);
    }

    /*
     * 更改住院医嘱信息
     * 1:护士审核
     * */

    @Override
    public void modifyPatientOrderByPatientId(PatientOrderDTO patientOrderDTO) {
        //TODO
        for (TreatmentDTO treatment : patientOrderDTO.getTreatments()) {
            PatientOrder patientOrder = getPatientOrder(patientOrderDTO, treatment);
        }
        if (patientOrderDTO.getExecutionStatus() == 2) {
//                patientOrderMapper.updatePatientOrderByPatientId(patientOrderDTO);
            if (patientOrderDTO.getOrderType() == 1) {
                this.timedExecutionAddPatientOrder();
            }
            log.info("审核通过~~~");
        } else {
//                patientOrderMapper.updatePatientOrderByPatientId(patientOrderDTO);
            log.info("执行状态码={}", patientOrderDTO.getExecutionStatus());
        }
    }


    /*
     * 定时执行长期医嘱
     * */
//    @Scheduled(fixedRate = 1000 * 10)
    @Override
    public void timedExecutionAddPatientOrder() {
        //获取执行状态为2和医嘱类型为2的住院患者医嘱
        List<PatientOrder> patientOrders = patientOrderMapper.selectPatientOrderByStatus(2, 2);
        for (PatientOrder patientOrder : patientOrders) {
            //判断执行时间与当前时间的日期是否是昨天的日期并且审核状态为2
            if (patientOrder.getExecutionTime().toLocalDate().equals(LocalDate.now().minusDays(1)) && patientOrder.getExecutionStatus()==2){
                patientOrderMapper.addPatientOrderByPatientOrderId(patientOrder);
            }
        }
    }

    @Transactional
    @Override
    public void dischargePatient(PatientInfoDTO patientInfoDTO) {
        //添加出院医嘱
        patientOrderMapper.dischargePatient(patientInfoDTO);
        //添加出院费用表
        patientBillMapper.dischargePatient(patientInfoDTO);

    }

    @Override
    public void checkDischarge(Integer status, Integer patientId) {
        patientOrderMapper.checkDischarge(status,patientId);

    }

    /*
     * PatientOrderDTO转PatientOrder
     * */
    private PatientOrder getPatientOrder(PatientOrderDTO patientOrderDTO, TreatmentDTO treatment) {
        PatientOrder patientOrder = new PatientOrder();
        patientOrder.setPatientOrderId(patientOrderDTO.getPatientOrderId());
        patientOrder.setPatientId(patientOrderDTO.getPatientId());
        patientOrder.setDoctorId(patientOrderDTO.getDoctorId());
        patientOrder.setTreatmentId(treatment.getTreatmentId());
        patientOrder.setTreatmentName(treatment.getTreatmentName());
        patientOrder.setAdministrationId(patientOrderDTO.getAdministrationId());
        patientOrder.setDosageId(patientOrderDTO.getDosageId());
        patientOrder.setTreatmentCount(treatment.getTreatmentCount());
        patientOrder.setOrderType(patientOrderDTO.getOrderType());
        return patientOrder;
    }


}
