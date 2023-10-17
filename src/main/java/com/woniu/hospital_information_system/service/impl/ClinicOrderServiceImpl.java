package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.controller.VisitorInfoController;
import com.woniu.hospital_information_system.entity.ClinicOrder;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.mapper.ClinicOrderMapper;
import com.woniu.hospital_information_system.mapper.VisitorBillMapper;
import com.woniu.hospital_information_system.mapper.VisitorInfoMapper;
import com.woniu.hospital_information_system.service.ClinicOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClinicOrderServiceImpl implements ClinicOrderService {
    @Autowired
    ClinicOrderMapper clinicOrderMapper;
    @Autowired
    VisitorInfoMapper visitorInfoMapper;
    @Autowired
    VisitorBillMapper visitorBillMapper;

    @Transactional
    @Override
    public void addClinicOrder(ClinicOrder clinicOrder) {
        clinicOrderMapper.addClinicOrder(clinicOrder);
        VisitorInfo visitorInfoByVisitorId = visitorInfoMapper.getVisitorInfoByVisitorId(clinicOrder.getVisitorId());
        visitorInfoMapper.updateClinicStatusAndDisease(visitorInfoByVisitorId);
        Integer treatmentCategoryByTreatmentId = visitorBillMapper.getTreatmentCategoryByTreatmentId(clinicOrder);

    }
}
