package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.InsuranceInfo;
import com.woniu.hospital_information_system.mapper.InsuranceInfoMapper;
import com.woniu.hospital_information_system.service.InsuranceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceInfoServiceImpl implements InsuranceInfoService {
    @Autowired
    InsuranceInfoMapper insuranceInfoMapper;
    @Override
    public InsuranceInfo getInsuranceInfoByIdNumber(String idNumber) {
        return insuranceInfoMapper.selectInsuranceInfoByIdNumber(idNumber);
    }
}
