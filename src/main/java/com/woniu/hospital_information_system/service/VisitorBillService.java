package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.VisitorInfo;

import java.sql.Timestamp;

public interface VisitorBillService {
    void addVisitorBillByVisitorIdAndEmployeeId(Integer visitorId, Integer treatmentId, Double treatmentPrice, Timestamp orderDate);

    Double getPriceByTreatmentId(Integer treatmentId);

    void updatePayStatus(Integer visitorId);
}
