package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.VO.VisitorBillResultVO;
import com.woniu.hospital_information_system.entity.VO.VisitorBillVO;
import com.woniu.hospital_information_system.entity.VisitorBill;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.mapper.VisitorBillMapper;
import com.woniu.hospital_information_system.mapper.VisitorInfoMapper;
import com.woniu.hospital_information_system.service.VisitorBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VisitorBillServiceImpl implements VisitorBillService {
    @Autowired
    VisitorBillMapper visitorBillMapper;
    @Autowired
    VisitorInfoMapper visitorInfoMapper;

    @Override
    public VisitorBillResultVO getVisitorBillVO(Integer patientId) {
        VisitorBillResultVO visitorBillResultVO = new VisitorBillResultVO();
        VisitorInfo visitorInfo = visitorInfoMapper.getVisitorInfoByVisitorId(patientId);
        visitorBillResultVO.setVisitorInfo(visitorInfo);
        List<VisitorBillVO> visitorBillVOList = visitorBillMapper.getAllBillsByVisitorId(patientId);
        Double finalPrice = getFinalPrice(patientId);
        visitorBillResultVO.setVisitorBillVOList(visitorBillVOList);
        visitorBillResultVO.setFinalPrice(finalPrice);
        return visitorBillResultVO;
    }
    @Override
    public void addVisitorBillByVisitorIdAndEmployeeId(Integer visitorId, Integer treatmentId, Double treatmentPrice) {
        visitorBillMapper.addVisitorBill(visitorId,treatmentId,treatmentPrice);
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
    public void changePaymentStatus(Integer visitorBillId) {
        visitorBillMapper.changePaymentStatus(visitorBillId);
    }

    @Override
    public Double getFinalPrice(Integer visitorId) {
        //查询所有相关账单
        List<VisitorBillVO> bills =  visitorBillMapper.getAllBillsByVisitorId(visitorId);
        double sum  = 0;
        //遍历获取每个金额并相加 并用billid更改支付状态
        for (VisitorBillVO visitorBill : bills){
           sum =sum +  visitorBill.getTreatmentPrice();
        }
        return sum;
    }

    @Override
    public void changeAllStatus(Integer visitorId) {
        List<VisitorBillVO> bills =  visitorBillMapper.getAllBillsByVisitorId(visitorId);
        for (VisitorBillVO visitorBill : bills){
            visitorBillMapper.changePaymentStatus(visitorBill.getVisitorBillId());
        }
    }


}
