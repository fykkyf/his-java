package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.VO.VisitorBillResultVO;

public interface VisitorBillService {
    void addVisitorBillByVisitorIdAndEmployeeId(Integer visitorId, Integer treatmentId, Double treatmentPrice);

    Double getPriceByTreatmentId(Integer treatmentId);

    void updatePayStatus(Integer visitorId);


    void changePaymentStatus(Integer visitorBillId);

    Double getFinalPrice(Integer visitorId);

    void changeAllStatus(Integer visitorId);

    VisitorBillResultVO getVisitorBillVO(Integer patientId);
}
