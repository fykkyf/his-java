package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.PatientBill;
import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.entity.VO.PatientBillResultVO;
import com.woniu.hospital_information_system.entity.VO.PatientBillVO;
import com.woniu.hospital_information_system.mapper.PatientBillMapper;
import com.woniu.hospital_information_system.mapper.PatientInfoMapper;
import com.woniu.hospital_information_system.service.PatientBillService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientBillServiceImpl implements PatientBillService {
    @Autowired
    PatientBillMapper patientBillMapper;
    @Autowired
    PatientInfoMapper patientInfoMapper;

    @Override
    public PatientBillResultVO getPatientBillVO(Integer patientId) {
        PatientBillResultVO patientBillResultVO = new PatientBillResultVO();
        PatientInfo patientInfo = patientInfoMapper.selectPatientInfoByPatientId(patientId);
        int insuranceStatus= patientInfo.getInsuranceStatus();
        patientBillResultVO.setPatientInfo(patientInfo);
        List<PatientBillVO> patientBillVOList = patientBillMapper.getPatientBillVO(patientId);
        if(insuranceStatus==2){
            for (PatientBillVO p : patientBillVOList){
                if(p.getInsurancePrice()!= null && p.getDrugCount()!=null){
                    int count = p.getDrugCount();

                    double price = p.getInsurancePrice();

                    double sum = count * price;

                    p.setFinalPrice(sum);
                }else if(p.getInsurancePrice()!= null && p.getDrugCount()==null){
                    p.setFinalPrice(p.getInsurancePrice());
                }
            }

        }else {
            for (PatientBillVO p : patientBillVOList){
                if(p.getTreatmentPrice()!= null && p.getDrugCount()!=null){
                    int count = p.getDrugCount();

                    double price = p.getTreatmentPrice();

                    double sum = count * price;

                    p.setFinalPrice(sum);
                }else if(p.getTreatmentPrice()!= null && p.getDrugCount()==null){
                    p.setFinalPrice(p.getTreatmentPrice());
                }
            }

        }
        patientBillResultVO.setPatientBillVOList(patientBillVOList);
        double finalPrice = getPaymentSum(patientBillVOList);
        patientBillResultVO.setFinalPrice(finalPrice);
        return patientBillResultVO;
    }

    @Override
    public void billPaymentStatus(Integer patientBillId) {
        patientBillMapper.billPaymentStatus(patientBillId);
    }

    @Override
    public Double getPaymentSum(List<PatientBillVO> patientBillVOList) {
        double result = 0;
        for (PatientBillVO p : patientBillVOList){
            result = result + p.getFinalPrice();
        }
        return result;
    }

    @Override
    public List<Integer> getAllBillIds(Integer patientId) {
        return patientBillMapper.getAllBillIds(patientId);
    }




}
