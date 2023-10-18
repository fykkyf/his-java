package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.VisitorBill;
import com.woniu.hospital_information_system.entity.VisitorInfo;

import java.sql.Timestamp;
import java.util.List;

public interface VisitorBillService {
    void addVisitorBillByVisitorIdAndEmployeeId(Integer visitorId, Integer treatmentId, Double treatmentPrice, Timestamp orderDate);

    Double getPriceByTreatmentId(Integer treatmentId);

    void updatePayStatus(Integer visitorId);

    List<VisitorBill> getAllBillsByVisitorId(Integer visitorId);

    void changePaymentStatus(Integer visitorBillId);

    Double changeAllpayment(VisitorInfo visitorInfo);

    void changeAllStatus(Integer visitorId);
}
