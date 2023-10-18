package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.RegularResult;
import com.woniu.hospital_information_system.mapper.RegularResultMapper;
import com.woniu.hospital_information_system.service.RegularResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegularResultServiceImpl implements RegularResultService {
    @Autowired
    RegularResultMapper regularResultMapper;

    /*
    * 根据patientId查询三测信息
    * */
    @Override
    public RegularResult getRegularByPatientId(Integer patientId) {
        List<RegularResult> regularResults = regularResultMapper.selectRegularByPatientId(patientId);
        return null;
    }
}
