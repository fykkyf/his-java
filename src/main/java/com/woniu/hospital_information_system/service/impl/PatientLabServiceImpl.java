package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.DTO.PatientLabDTO;
import com.woniu.hospital_information_system.entity.VO.PatientLabVO;
import com.woniu.hospital_information_system.mapper.PatientLabMapper;
import com.woniu.hospital_information_system.service.PatientLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientLabServiceImpl implements PatientLabService {
    @Autowired
    PatientLabMapper patientLabMapper;
    @Override
    public List<PatientLabVO> getAllPatientLab(PatientLabDTO patientLabDTO) {
        return patientLabMapper.getAllPatientLab(patientLabDTO);
    }

    @Override
    public void updateAllPatientLab(PatientLabDTO patientLabDTO) {
        patientLabMapper.updateAllPatientLab(patientLabDTO);
    }

    @Override
    public void updatePb(PatientLabDTO patientLabDTO) {
        patientLabMapper.updatePb(patientLabDTO);
    }
}
