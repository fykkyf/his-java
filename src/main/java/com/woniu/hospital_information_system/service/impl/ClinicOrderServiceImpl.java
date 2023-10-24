package com.woniu.hospital_information_system.service.impl;


import com.woniu.hospital_information_system.entity.ClinicOrder;
import com.woniu.hospital_information_system.entity.DTO.ClinicOrderDTO;
import com.woniu.hospital_information_system.entity.DTO.TreatmentDTO;
import com.woniu.hospital_information_system.entity.VO.TreatmentVO;
import com.woniu.hospital_information_system.mapper.ClinicOrderMapper;
import com.woniu.hospital_information_system.mapper.TreatmentMapper;
import com.woniu.hospital_information_system.mapper.VisitorBillMapper;
import com.woniu.hospital_information_system.mapper.VisitorInfoMapper;
import com.woniu.hospital_information_system.service.ClinicOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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



    @Transactional
    @Override
    public void addClinicOrder(ClinicOrderDTO clinicOrderDTO) {
        clinicOrderMapper.addClinicOrder(clinicOrderDTO);
        Double priceByTreatmentId = clinicOrderMapper.getPriceByTreatmentId(clinicOrderDTO);
        System.out.println("这里是service"+clinicOrderDTO.getTreatment().getTreatmentId());
        visitorBillMapper.addClinicOrderBill(clinicOrderDTO.getVisitorId(),clinicOrderDTO.getTreatment().getTreatmentId(),clinicOrderDTO.getTreatmentCount(),priceByTreatmentId);
        TreatmentDTO treatmentDTO = new TreatmentDTO();
        treatmentDTO.setTreatmentId(clinicOrderDTO.getTreatmentId());
        Map<Integer, Boolean> addedTreatmentIds = new HashMap<>();
        List<TreatmentVO> treatmentVOS = treatmentMapper.selectAllTreatment(treatmentDTO);
        for (TreatmentVO treatmentVO : treatmentVOS) {
            Integer treatmentCategory = treatmentVO.getTreatmentCategory();
            if (treatmentCategory == 3) {
                if (!addedTreatmentIds.containsKey(treatmentCategory)) {
                    clinicOrderMapper.addClinicLab(clinicOrderDTO);
                    addedTreatmentIds.put(treatmentCategory, true);
                }
            } else if (treatmentCategory == 4) {
                if (!addedTreatmentIds.containsKey(treatmentCategory)) {
                    clinicOrderMapper.addClinicRaidology(clinicOrderDTO);
                    addedTreatmentIds.put(treatmentCategory, true);
                }
            }
        }
//        for (TreatmentVO treatmentVO:treatmentVOS) {
//            Integer treatmentCategory = treatmentVO.getTreatmentCategory();
//            if(treatmentCategory==3){
//                clinicOrderMapper.addClinicLab(clinicOrderDTO);
//            } else if (treatmentCategory==4) {
//                clinicOrderMapper.addClinicRaidology(clinicOrderDTO);
//            }
//        }
    }
}
