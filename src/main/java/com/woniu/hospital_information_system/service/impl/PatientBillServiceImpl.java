package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.PatientBill;
import com.woniu.hospital_information_system.entity.VO.PatientBillVO;
import com.woniu.hospital_information_system.mapper.PatientBillMapper;
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


    @Override
    public List<PatientBillVO> getPatientBillVO(Integer patientId,Integer insuranceStatus) {
        List<PatientBillVO> patientBillVOList = patientBillMapper.getPatientBillVO(patientId);
        if(insuranceStatus==1){
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
            return patientBillVOList;
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
            return patientBillVOList;
        }

    }
}
