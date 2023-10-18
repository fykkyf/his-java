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
    public List<PatientBillVO> getPatientBillVO(Integer patientId) {
        List<PatientBillVO> patientBillVOList1 = patientBillMapper.getPatientBillVO(patientId);

        for (PatientBillVO p : patientBillVOList1){
            if(p.getInsurancePrice()!= null && p.getDrugCount()!=null){
                int count = p.getDrugCount();

                double price = p.getInsurancePrice();

                double sum = count * price;

                p.setFinalPrice(sum);
            }
        }
        return patientBillVOList1;
    }
}
