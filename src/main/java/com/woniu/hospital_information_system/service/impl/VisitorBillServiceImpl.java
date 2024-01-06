package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.VO.PatientBillVO;
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
    public VisitorBillResultVO getVisitorBillVO(Integer visitorId) {
        VisitorBillResultVO visitorBillResultVO = new VisitorBillResultVO();
        VisitorInfo visitorInfo = visitorInfoMapper.getVisitorInfoByVisitorId(visitorId);
        if (visitorInfo == null){
            return null;
        }
        visitorBillResultVO.setVisitorInfo(visitorInfo);
        List<VisitorBillVO> visitorBillVOList = visitorBillMapper.getAllBillsByVisitorId(visitorId);
        if(visitorBillVOList.isEmpty()){
            return null;
        }
        for (VisitorBillVO p : visitorBillVOList) {
            if (p.getTreatmentPrice() != null && p.getDrugCount() != null) {
                int count = p.getDrugCount();

                double price = p.getTreatmentPrice();

                double sum = count * price;

                p.setFinalPrice(sum);
            } else if (p.getTreatmentPrice() != null && p.getDrugCount() == null) {
                p.setFinalPrice(p.getTreatmentPrice());
            }else {
                p.setDrugCount(0);
                p.setTreatmentPrice(0.0);
                p.setFinalPrice(0.0);
            }
        }
        Double finalPrice = getFinalPrice(visitorBillVOList);
        visitorBillResultVO.setVisitorBillVOList(visitorBillVOList);
        visitorBillResultVO.setFinalPrice(finalPrice);
        return visitorBillResultVO;
    }

    @Override
    public VisitorBillResultVO getRefundBillVO(Integer visitorId) {
        VisitorBillResultVO visitorBillResultVO = new VisitorBillResultVO();
        VisitorInfo visitorInfo = visitorInfoMapper.getVisitorInfoByVisitorId(visitorId);
        visitorBillResultVO.setVisitorInfo(visitorInfo);
        List<VisitorBillVO> visitorBillVOList = visitorBillMapper.getRefundBillsByVisitorId(visitorId);
        for (VisitorBillVO p : visitorBillVOList) {
            if (p.getTreatmentPrice() != null && p.getDrugCount() != null) {
                int count = p.getDrugCount();

                double price = p.getTreatmentPrice();

                double sum = count * price;

                p.setFinalPrice(sum);
            } else if (p.getTreatmentPrice() != null && p.getDrugCount() == null) {
                p.setFinalPrice(p.getTreatmentPrice());
            }else {
                p.setDrugCount(0);
                p.setTreatmentPrice(0.0);
                p.setFinalPrice(0.0);
            }
        }
        Double finalPrice = getFinalPrice(visitorBillVOList);
        visitorBillResultVO.setVisitorBillVOList(visitorBillVOList);
        visitorBillResultVO.setFinalPrice(finalPrice);
        return visitorBillResultVO;
    }

    @Override
    public void updateManipulateStatus(VisitorBill visitorBill) {
        visitorBillMapper.updateManipulateStatus(visitorBill);
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
    public void refundPayment(Integer visitorBillId) {
        visitorBillMapper.refundPayment(visitorBillId);
    }

    @Override
    public Double getFinalPrice(List<VisitorBillVO> visitorBillVOList ) {
        //查询所有相关账单

        double sum  = 0;
        //遍历获取每个金额并相加 并用billid更改支付状态
        for (VisitorBillVO visitorBill : visitorBillVOList){
            if(visitorBill.getFinalPrice()!=0){
                sum =sum +  visitorBill.getFinalPrice();
            }

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
