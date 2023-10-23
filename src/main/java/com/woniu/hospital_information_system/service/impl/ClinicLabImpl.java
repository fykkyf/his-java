package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.DTO.ClinicLabDTO;
import com.woniu.hospital_information_system.entity.VO.ClinicLabVO;
import com.woniu.hospital_information_system.mapper.ClinicLabMapper;
import com.woniu.hospital_information_system.service.ClinicLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicLabImpl implements ClinicLabService {
    @Autowired
    ClinicLabMapper clinicLabMapper;
    @Override
    public List<ClinicLabVO> getAllClinicLab(ClinicLabDTO clinicLabDTO) {
        return clinicLabMapper.getAllClinicLab(clinicLabDTO);
    }

    @Override
    public void updateAllClinicLab(ClinicLabDTO clinicLabDTO) {
        clinicLabMapper.updateAllClinicLab(clinicLabDTO);
    }

    @Override
    public void updateVb(ClinicLabDTO clinicLabDTO) {
        clinicLabMapper.updateVb(clinicLabDTO);
    }
}
