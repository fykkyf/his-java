package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.RegularResult;

public interface RegularResultService {
    //根据patientId查询三测信息
    RegularResult getRegularByPatientId(Integer patientId);
}
