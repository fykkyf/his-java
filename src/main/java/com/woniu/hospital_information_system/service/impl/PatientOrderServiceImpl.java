package com.woniu.hospital_information_system.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.hospital_information_system.entity.*;
import com.woniu.hospital_information_system.entity.DTO.PatientInfoDTO;
import com.woniu.hospital_information_system.entity.DTO.PatientOrderDTO;
import com.woniu.hospital_information_system.entity.DTO.TreatmentDTO;
import com.woniu.hospital_information_system.entity.VO.PatientOrderVO;
import com.woniu.hospital_information_system.mapper.*;
import com.woniu.hospital_information_system.service.PatientLabService;
import com.woniu.hospital_information_system.service.PatientOrderService;
import com.woniu.hospital_information_system.service.PatientRaidologyService;
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
    @Autowired
    LocationMapper locationMapper;
    @Autowired
    PatientRaidologyMapper patientRaidologyMapper;//检查--4
    @Autowired
    PatientLabMapper patientLabMapper;//检验--3

    /*
     * 获取所有住院患者医嘱信息
     * */
    @Override
    public PatientOrderVO getAllPatientOrders(int pageNum, int pageSize) {
        List<PatientOrder> patientOrders = patientOrderMapper.selectAllPatientOrders();
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<PatientOrder> info = new PageInfo<>(patientOrders);
        PatientOrderVO patientOrderVO = new PatientOrderVO();
        patientOrderVO.setPageNum(pageNum);
        patientOrderVO.setPageSize(pageSize);
        patientOrderVO.setTotal((int) info.getTotal());
        patientOrderVO.setPatientOrders(patientOrders);
        return patientOrderVO;
    }

    @Override
    public PatientOrderVO getAllPatientOrdersByDaily(int pageNum, int pageSize, int patientId) {
        List<PatientOrder> patientOrders = patientOrderMapper.selectAllPatientOrdersByDaily(patientId);
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<PatientOrder> info = new PageInfo<>(patientOrders);
        PatientOrderVO patientOrderVO = new PatientOrderVO();
        patientOrderVO.setPageNum(pageNum);
        patientOrderVO.setPageSize(pageSize);
        patientOrderVO.setTotal((int) info.getTotal());
        patientOrderVO.setPatientOrders(patientOrders);
        return patientOrderVO;
    }

    /*
     * 医生给住院患者下医嘱
     * */
    @Transactional
    @Override
    public void addPatientOrder(PatientOrderDTO patientOrderDTO) {
        //TODO:从token中获取医生ID
        TreatmentDTO treatment = patientOrderDTO.getTreatment();
        treatment.setTreatmentName(treatmentMapper.selectTreatmentByTreatmentId(treatment.getTreatmentId()).getTreatmentName());
        System.out.println(patientOrderDTO.getAdministrationId());
        System.out.println(patientOrderDTO.getDosageId());
        PatientOrder patientOrder = getPatientOrder(patientOrderDTO);
        if (treatment.getTreatmentCategory()!=1){
            patientOrder.setOrderType(1);
        }
        patientOrderMapper.addPatientOrderByPatientOrderId(patientOrder);//添加医嘱
        if (treatment.getTreatmentCategory() == 2 ) {
            //非药品并且项目id不为7(出院项目)-添加费用明细
            if (treatment.getTreatmentId().equals(7)) {
                //是出院项目---添加出院诊断
                PatientInfo patientInfo = new PatientInfo();
                patientInfo.setPatientId(patientOrderDTO.getPatient().getPatientId());
                patientInfo.setDischargeDiagnosis(patientOrderDTO.getDischargeDiagnosis());
                patientInfoMapper.dischargeDiagnosis(patientInfo);//添加出院诊断
                patientBillMapper.dischargePatient(patientInfo.getPatientId());//添加出院费用--记账状态码为-1(未记账)
            } else {
                patientBillMapper.insertPatientBill(getPatientBill(treatment, patientOrder));//添加项目费用
            }
        }else if (treatment.getTreatmentCategory() == 3){
            //检验
            patientLabMapper.insertPatientLab(patientOrder.getPatient().getPatientId(),treatment.getTreatmentId());
        }else if (treatment.getTreatmentCategory() == 4){
            //检查
            patientRaidologyMapper.insertPatientRaidology(patientOrder.getPatient().getPatientId(),treatment.getTreatmentId());
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
        TreatmentDTO treatment = patientOrderDTO.getTreatment();
        PatientOrder patientOrder = getPatientOrder(patientOrderDTO);
        //更改执行状态
        patientOrderMapper.updatePatientOrderStatusByPatientId(patientOrder);
        if (patientOrder.getExecutionStatus() == 2) {
            Treatment byTreatmentId = treatmentMapper.selectTreatmentByTreatmentId(treatment.getTreatmentId());
            treatment.setTreatmentPrice(byTreatmentId.getTreatmentPrice());//获取实际金额
            treatment.setTreatmentCategory(byTreatmentId.getTreatmentCategory());//设置项目类别
            PatientBill patientBill = getPatientBill(treatment, patientOrder);
            //判断项目类别
            if (treatment.getTreatmentCategory() == 1) {
                //药品项目：
                //修改医嘱表中的执行时间
                patientOrderMapper.updatePatientOrderTimesByPatientId(patientOrder);
                // 住院患者费用表中添加一条数据记账状态为2的数据
                patientBillMapper.insertPatientBill(patientBill);
            } else if (treatment.getTreatmentId().equals(7)) {
                //出院项目
                //修改医嘱表中的执行时间
                patientOrderMapper.updatePatientOrderTimesByPatientId(patientOrder);
                // 修改费用明细中payment_status为2--记账时间为now
                patientBillMapper.updatePatientBillByPaymentStatus(patientBill);
                PatientInfo patientInfo = new PatientInfo();
                patientInfo.setPatientId(patientOrder.getPatient().getPatientId());
                //更新床位表
                locationMapper.updateLocationStatusEmpty(patientInfoMapper.selectPatientInfoByPatientId(patientInfo.getPatientId()).getLocation().getLocationId());
                //修改病人信息表中床位信息
                patientInfo.setLocation(new Location());
                patientInfoMapper.updatePatientInfo(patientInfo);//清空病人信息表中床位
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
                patientBill.setPatientId(patientOrder.getPatient().getPatientId());
                patientBill.setTreatmentId(patientOrder.getTreatmentId());
                patientBill.setDrugCount(patientOrder.getTreatmentCount());
                patientBill.setTreatmentPrice(treatmentMapper.selectTreatmentByTreatmentId(patientOrder.getTreatmentId()).getTreatmentPrice() * patientOrder.getTreatmentCount());
                patientOrderMapper.addPatientOrderByPatientOrderId(patientOrder);//添加医嘱
                patientBillMapper.insertPatientBill(patientBill);//添加费用
            }
        }
    }

    /*
    * 办理出院----费用表状态
    * */
    @Transactional
    @Override
    public void dischargePatient(PatientInfoDTO patientInfoDTO) {
        //修改出院病人费用表状态
        patientBillMapper.completeDischarge(patientInfoDTO);


    }

    /*
    * 修改医嘱执行状态
    * */
    @Override
    public void checkDischarge(Integer status, Integer patientId) {
        patientOrderMapper.checkDischarge(status, patientId);

    }

    @Override
    public void finishPayment(Integer patientId) {
        patientOrderMapper.finishPayment(patientId);
    }

    /*
    * 模糊查询住院患者医嘱信息
    * */
    @Override
    public List<PatientOrder> getPatientOrderByKeyWord(PatientOrderDTO patientOrderDTO) {
        return patientOrderMapper.selectPatientOrderByKeyWord(getPatientOrder(patientOrderDTO));
    }

    /*
    *   医生修改病人医嘱信息
    * */
    @Override
    public void modifyPatientOrder(PatientOrderDTO patientOrderDTO) {
        patientOrderMapper.updatePatientOrderByPatientId(getPatientOrder(patientOrderDTO));
    }



    /*
     * PatientOrderDTO转PatientOrder
     * */
    private PatientOrder getPatientOrder(PatientOrderDTO patientOrderDTO) {
        PatientOrder patientOrder = new PatientOrder();
        if (patientOrderDTO.getPatientOrderId()!=null){
            patientOrder.setPatientOrderId(patientOrderDTO.getPatientOrderId());
        }
        if(patientOrderDTO.getPatient()!=null){
            patientOrder.setPatient(patientOrderDTO.getPatient());
        }
        if(patientOrderDTO.getEmployee()!=null){
            patientOrder.setEmployee(patientOrderDTO.getEmployee());
        }
        if (patientOrderDTO.getTreatment()!=null){
            patientOrder.setTreatmentId(patientOrderDTO.getTreatment().getTreatmentId());
            patientOrder.setTreatmentName(patientOrderDTO.getTreatment().getTreatmentName());
            patientOrder.setTreatmentCount(patientOrderDTO.getTreatment().getTreatmentCount());
        }
        if (patientOrderDTO.getAdministrationId()!=null){
            Administration administration = new Administration();
            administration.setAdministrationId(patientOrderDTO.getAdministrationId());
            patientOrder.setAdministration(administration);
        }
        if (patientOrderDTO.getDosageId()!=null){
            Dosage dosage = new Dosage();
            dosage.setDosageId(patientOrderDTO.getDosageId());
            patientOrder.setDosage(dosage);
        }
        if(patientOrderDTO.getExecutionStatus()!=null){
            patientOrder.setExecutionStatus(patientOrderDTO.getExecutionStatus());
        }
        if(patientOrderDTO.getOrderType()!=null){
            patientOrder.setOrderType(patientOrderDTO.getOrderType());
        }
        return patientOrder;
    }

    /*
     * 通过TreatmentDTO+PatientOrder返回PatientBill
     * */
    private PatientBill getPatientBill(TreatmentDTO treatment, PatientOrder patientOrder) {
        PatientBill patientBill = new PatientBill();
        patientBill.setPatientId(patientOrder.getPatient().getPatientId());
        patientBill.setTreatmentId(treatment.getTreatmentId());
        patientBill.setDrugCount(treatment.getTreatmentCount());
        //计算费用
        if (treatment.getTreatmentCount() == null) {
            patientBill.setTreatmentPrice(0d);
        } else {
            patientBill.setTreatmentPrice(treatment.getTreatmentCount() * treatment.getTreatmentPrice());
        }
        return patientBill;
    }


}
