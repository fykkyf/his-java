package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.Dosage;
import com.woniu.hospital_information_system.mapper.DosageMapper;
import com.woniu.hospital_information_system.service.DosageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DosageServiceImpl implements DosageService {
    @Autowired
    DosageMapper dosageMapper;

    @Override
    public List<Dosage> getAllDosages() {
        return dosageMapper.selectDosages();
    }
}
