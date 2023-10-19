package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.RegularResult;

import java.util.List;

public interface RegularResultService {
    //根据patientId查询三测信息
    List<RegularResult> getRegularByPatientId(Integer patientId);
    //添加三测信息
    void addRegularResult(RegularResult regularResult);
}
