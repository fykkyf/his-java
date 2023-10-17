package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.InsuranceInfo;

public interface InsuranceInfoService {
    InsuranceInfo getInsuranceInfoByIdNumber(String idNumber);
}
