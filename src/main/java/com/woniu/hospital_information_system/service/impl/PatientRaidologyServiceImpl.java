package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.mapper.PatientRaidologyMapper;

import com.woniu.hospital_information_system.service.PatientRaidologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientRaidologyServiceImpl implements PatientRaidologyService {
    @Autowired
    PatientRaidologyMapper patientRaidologyMapper;

    @Override
    public void addPicture(String path, String fileName,Integer patientRaidologyId) {
        patientRaidologyMapper.addPicture(path,fileName,patientRaidologyId);
    }

    @Override
    public String getPictureFileName(VisitorInfo visitorInfo) {
        return patientRaidologyMapper.getPictureFileName(visitorInfo);
    }
}
