package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.VisitorBill;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.mapper.VisitorBillMapper;
import com.woniu.hospital_information_system.service.VisitorBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

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

    @Override
    public List<VisitorBill> getAllBillsByVisitorId(Integer visitorId) {
        return visitorBillMapper.getAllBillsByVisitorId(visitorId);
    }

    @Override
    public void changePaymentStatus(Integer visitorBillId) {
        visitorBillMapper.changePaymentStatus(visitorBillId);
    }

    @Override
    public Double changeAllpayment(VisitorInfo visitorInfo) {
        //查询所有相关账单
        List<VisitorBill> bills =  visitorBillMapper.getAllBillsByVisitorId(visitorInfo.getVisitorId());
        double sum  = 0;
        //遍历获取每个金额并相加 并用billid更改支付状态
        for (VisitorBill visitorBill : bills){
           sum =sum +  visitorBill.getTreatmentPrice();
        }
        return sum;
    }

    @Override
    public void changeAllStatus(Integer visitorId) {
        List<VisitorBill> bills =  visitorBillMapper.getAllBillsByVisitorId(visitorId);
        for (VisitorBill visitorBill : bills){
            visitorBillMapper.changePaymentStatus(visitorBill.getVisitorBillId());
        }
    }
}
