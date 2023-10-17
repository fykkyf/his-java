package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.mapper.VisitorBillMapper;
import com.woniu.hospital_information_system.service.VisitorBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class VisitorBillServiceImpl implements VisitorBillService {
    @Autowired
    VisitorBillMapper visitorBillMapper;

    @Override
    public void addVisitorBillByVisitorIdAndEmployeeId(Integer visitorId, Integer treatmentId, Double treatmentPrice, Timestamp orderDate) {
        visitorBillMapper.addVisitorBill(visitorId,treatmentId,treatmentPrice,orderDate);
    }

    @Override
    public Double getPriceByTreatmentId(Integer treatmentId) {
        return visitorBillMapper.getPriceByTreatmentId(treatmentId);
    }

    @Override
    public void updatePayStatus(Integer visitorId) {
        visitorBillMapper.updatePayStatus(visitorId);
    }
}
