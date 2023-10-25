package com.woniu.hospital_information_system.service.impl;


import com.woniu.hospital_information_system.entity.ClinicOrder;
import com.woniu.hospital_information_system.entity.DTO.ClinicOrderDTO;
import com.woniu.hospital_information_system.entity.DTO.TreatmentDTO;
import com.woniu.hospital_information_system.entity.Treatment;
import com.woniu.hospital_information_system.entity.VO.ClinicOrderVO;
import com.woniu.hospital_information_system.entity.VO.TreatmentVO;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.mapper.*;
import com.woniu.hospital_information_system.service.ClinicOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClinicOrderServiceImpl implements ClinicOrderService {
    @Autowired
    ClinicOrderMapper clinicOrderMapper;
    @Autowired
    VisitorInfoMapper visitorInfoMapper;
    @Autowired
    VisitorBillMapper visitorBillMapper;
    @Autowired
    TreatmentMapper treatmentMapper;
    @Autowired
    AdministrationMapper administrationMapper;
    @Autowired
    DosageMapper dosageMapper;



    @Transactional
    @Override
    public void addClinicOrder(ClinicOrderDTO clinicOrderDTO) {
        System.out.println("这里是clinicDTO:"+clinicOrderDTO);
        Treatment treatment = treatmentMapper.selectTreatmentByTreatmentId(clinicOrderDTO.getTreatment().getTreatmentId());
        String treatmentName = treatment.getTreatmentName();
        System.out.println("这里是项目名字："+treatmentName);
        clinicOrderDTO.setTreatmentName(treatmentName);
        System.out.println("这里是就诊id:"+clinicOrderDTO.getVisitorId());
        Integer visitorId = clinicOrderDTO.getVisitorId();
        VisitorInfo docByVid = visitorInfoMapper.getVisitorInfoByVisitorId(visitorId);
        System.out.println("这里是一个门诊对象:"+docByVid);
        Integer employeeId = docByVid.getEmployee().getEmployeeId();
        clinicOrderDTO.setDoctorId(employeeId);
        System.out.println("这里是医生id:"+clinicOrderDTO.getDoctorId());


        clinicOrderMapper.addClinicOrder(clinicOrderDTO);
        Double priceByTreatmentId = clinicOrderMapper.getPriceByTreatmentId(clinicOrderDTO);
        System.out.println("这里是金额:"+priceByTreatmentId);
        System.out.println("这里是service"+clinicOrderDTO.getTreatment().getTreatmentId());
        visitorBillMapper.addClinicOrderBill(clinicOrderDTO.getVisitorId(),clinicOrderDTO.getTreatment().getTreatmentId(),clinicOrderDTO.getTreatmentCount(),priceByTreatmentId);
        Integer treatmentCategory = clinicOrderDTO.getTreatment().getTreatmentCategory();
        System.out.println("这里是treatmentCategory:"+treatmentCategory);
        if (treatmentCategory==3){
            clinicOrderMapper.addClinicLab(clinicOrderDTO);
        } else if (treatmentCategory==4) {
            clinicOrderMapper.addClinicRaidology(clinicOrderDTO);
        }
//        TreatmentDTO treatmentDTO = new TreatmentDTO();
//        treatmentDTO.setTreatmentId(clinicOrderDTO.getTreatmentId());
//        Map<Integer, Boolean> addedTreatmentIds = new HashMap<>();
//        List<TreatmentVO> treatmentVOS = treatmentMapper.selectAllTreatment(treatmentDTO);
//        for (TreatmentVO treatmentVO : treatmentVOS) {
//            Integer treatmentCategory = treatmentVO.getTreatmentCategory();
//            if (treatmentCategory == 3) {
//                if (!addedTreatmentIds.containsKey(treatmentCategory)) {
//                    clinicOrderMapper.addClinicLab(clinicOrderDTO);
//                    addedTreatmentIds.put(treatmentCategory, true);
//                }
//            } else if (treatmentCategory == 4) {
//                if (!addedTreatmentIds.containsKey(treatmentCategory)) {
//                    clinicOrderMapper.addClinicRaidology(clinicOrderDTO);
//                    addedTreatmentIds.put(treatmentCategory, true);
//                }
//            }
//        }
//        for (TreatmentVO treatmentVO:treatmentVOS) {
//            Integer treatmentCategory = treatmentVO.getTreatmentCategory();
//            if(treatmentCategory==3){
//                clinicOrderMapper.addClinicLab(clinicOrderDTO);
//            } else if (treatmentCategory==4) {
//                clinicOrderMapper.addClinicRaidology(clinicOrderDTO);
//            }
//        }
    }

    @Transactional
    @Override
    public List<ClinicOrderVO> getOrderByVisitorId(Integer visitorId) {
        List<ClinicOrderVO> orderByVisitorId = clinicOrderMapper.getOrderByVisitorId(visitorId);
        System.out.println("这里是一个集合:"+orderByVisitorId);
        return orderByVisitorId;
//        List<ClinicOrder> orderByVisitorId = clinicOrderMapper.getOrderByVisitorId(visitorId);
//        ClinicOrderVO clinicOrderVO = new ClinicOrderVO();
//        List<ClinicOrderVO> clinicOrderVOList = new ArrayList<>();
//        for (ClinicOrder order:orderByVisitorId) {
//            Integer clinicOrderId = order.getClinicOrderId();
//            String treatmentName = order.getTreatmentName();
//            Integer treatmentCount = order.getTreatmentCount();
//            LocalDateTime executionTime = order.getExecutionTime();
//            LocalDateTime dispenseTime = order.getDispenseTime();
//            clinicOrderVO.setClinicOrderId(clinicOrderId);
//            clinicOrderVO.setTreatmentName(treatmentName);
//            clinicOrderVO.setTreatmentCount(treatmentCount);
//            clinicOrderVO.setExecutionTime(executionTime);
//            clinicOrderVO.setDispenseTime(dispenseTime);
//            //得到用法id
//            Integer administrationId = order.getAdministrationId();
//            //通过用法id，获得用法名字
//            String adminName = administrationMapper.getById(administrationId);
//            clinicOrderVO.setAdministrationName(adminName);
//            //得到用量id
//            Integer dosageId = order.getDosageId();
//            //通过用量id，得到用量名字
//            String dosageNameById = dosageMapper.getById(dosageId);
//            clinicOrderVO.setDosageName(dosageNameById);
//
//            clinicOrderVOList.add(clinicOrderVO);
//        }
//        return clinicOrderVOList;
    }
}
