package com.woniu.hospital_information_system.service.impl;


import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.DTO.PatientOrderDTO;
import com.woniu.hospital_information_system.entity.DTO.TreatmentDTO;
import com.woniu.hospital_information_system.entity.PatientBill;
import com.woniu.hospital_information_system.entity.PatientOrder;
import com.woniu.hospital_information_system.mapper.*;
import com.woniu.hospital_information_system.service.PatientOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class PatientOrderServiceImpl implements PatientOrderService {
    @Autowired
    PatientOrderMapper patientOrderMapper;
    @Autowired
    PatientBillMapper patientBillMapper;
    @Autowired
    PatientInfoMapper patientInfoMapper;
    @Autowired
    TreatmentMapper treatmentMapper;

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
    @Transactional
    @Override
    public void addPatientOrder(PatientOrderDTO patientOrderDTO) {
        for (TreatmentDTO treatment : patientOrderDTO.getTreatments()) {
            PatientOrder patientOrder = getPatientOrder(patientOrderDTO, treatment);
            patientOrderMapper.addPatientOrderByPatientOrderId(patientOrder);//添加医嘱
            if (treatment.getTreatmentStatus()!=1){
                //非药品并且项目id不为7(出院项目)-添加费用明细
                if (treatment.getTreatmentId().equals(7)){
                    //添加出院诊断
//                    patientInfoMapper.dischargeDiagnosis();
                }else {
                    patientBillMapper.insertPatientBill(getPatientBill(treatment,patientOrder));//添加项目费用
                }
            }
        }
    }

    /*
     * 根据患者id查询住院医嘱信息
     * */
    @Override
    public List<PatientOrder> getPatientOrderByPatientId(int patientId) {
        return patientOrderMapper.selectPatientOrderByPatientId(patientId);
    }

    /*
     * 更改住院医嘱信息--添加相应的费用明细
     * 护士审核-药品:未审核[1]/执行[2]/驳回[3]/停止[4]
     * 审核出院
     * */
    @Transactional
    @Override
    public void modifyPatientOrderByPatientId(PatientOrderDTO patientOrderDTO) {
        for (TreatmentDTO treatment : patientOrderDTO.getTreatments()) {
            PatientOrder patientOrder = getPatientOrder(patientOrderDTO, treatment);
            //更改执行状态
            patientOrderMapper.updatePatientOrderByPatientId(patientOrder);
            if (patientOrder.getExecutionStatus() == 2) {
                //判断项目类别
                if (treatment.getTreatmentCategory() == 1) {
                    //药品项目：住院患者费用表中添加一条数据记账状态为2的数据
                    PatientBill patientBill = getPatientBill(treatment, patientOrder);
                    patientBillMapper.insertPatientBill(patientBill);
                }else if (treatment.getTreatmentId().equals(7)){
                    //出院项目：添加费用明细
                    patientBillMapper.dischargePatient(patientOrder.getPatientId());
                    //修改病人信息表中床位信息
//                    patientInfoMapper.updatePatientInfo();
                }
            }
        }
    }

    /*
     * 定时执行长期医嘱
     * 1:添加医嘱信息
     * 2:添加费用信息
     * */
//    @Scheduled(fixedRate = 1000 * 10)
    @Override
    public void timedExecutionAddPatientOrder() {
        //获取执行状态为2和医嘱类型为2的住院患者医嘱
        List<PatientOrder> patientOrders = patientOrderMapper.selectPatientOrderByStatus(2, 2);
        for (PatientOrder patientOrder : patientOrders) {
            //判断执行时间与当前时间的日期是否是昨天的日期并且审核状态为2
            if (patientOrder.getExecutionTime().toLocalDate().equals(LocalDate.now().minusDays(1)) && patientOrder.getExecutionStatus() == 2) {
                PatientBill patientBill = new PatientBill();
                patientBill.setPatientId(patientOrder.getPatientId());
                patientBill.setTreatmentId(patientOrder.getTreatmentId());
                patientBill.setDrugCount(patientOrder.getTreatmentCount());
                patientBill.setTreatmentPrice(treatmentMapper.selectTreatmentByTreatmentId(patientOrder.getTreatmentId()).getTreatmentPrice()*patientOrder.getTreatmentCount());
                patientOrderMapper.addPatientOrderByPatientOrderId(patientOrder);//添加医嘱
                patientBillMapper.insertPatientBill(patientBill);//添加费用
            }
        }
    }

    @Transactional
    @Override
    public void dischargePatient(PatientInfoDTO patientInfoDTO) {
        //添加出院医嘱
        patientOrderMapper.dischargePatient(patientInfoDTO);
        //添加出院费用表---需要护士审核
//        patientBillMapper.dischargePatient(patientInfoDTO.getPatientId());

    }

    @Override
    public void checkDischarge(Integer status, Integer patientId) {
        patientOrderMapper.checkDischarge(status, patientId);

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
        patientOrder.setExecutionStatus(patientOrderDTO.getExecutionStatus());
        patientOrder.setOrderType(patientOrderDTO.getOrderType());
        return patientOrder;
    }

    /*
     * 通过TreatmentDTO+PatientOrder返回PatientBill
     * */
    private PatientBill getPatientBill(TreatmentDTO treatment, PatientOrder patientOrder) {
        PatientBill patientBill = new PatientBill();
        patientBill.setPatientId(patientOrder.getPatientId());
        patientBill.setTreatmentId(patientOrder.getTreatmentId());
        patientBill.setDrugCount(patientOrder.getTreatmentCount());
        //计算费用
        patientBill.setTreatmentPrice(patientOrder.getTreatmentCount() * treatment.getTreatmentPrice());
        return patientBill;
    }


}
