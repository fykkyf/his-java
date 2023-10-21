package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.VO.VisitorBillResultVO;
import com.woniu.hospital_information_system.entity.VO.VisitorBillVO;

import java.util.List;

public interface VisitorBillService {
    void addVisitorBillByVisitorIdAndEmployeeId(Integer visitorId, Integer treatmentId, Double treatmentPrice);

    Double getPriceByTreatmentId(Integer treatmentId);

    void updatePayStatus(Integer visitorId);


    void refundPayment(Integer visitorBillId);

    Double getFinalPrice(List<VisitorBillVO> visitorBillVOList );

    void changeAllStatus(Integer visitorId);

    VisitorBillResultVO getVisitorBillVO(Integer patientId);

    VisitorBillResultVO getRefundBillVO(Integer visitorId);
}
