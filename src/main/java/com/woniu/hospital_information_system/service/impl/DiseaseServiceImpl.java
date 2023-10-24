package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.Disease;
import com.woniu.hospital_information_system.mapper.DiseaseMapper;
import com.woniu.hospital_information_system.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiseaseServiceImpl implements DiseaseService {
    @Autowired
    DiseaseMapper diseaseMapper;
    @Override
    public List<Disease> getAllDiseases() {
        return diseaseMapper.selectAllDisease();
    }
}
