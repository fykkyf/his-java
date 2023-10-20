package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.Administration;
import com.woniu.hospital_information_system.mapper.AdministrationMapper;
import com.woniu.hospital_information_system.service.AdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdministrationServiceImpl implements AdministrationService {
    @Autowired
    AdministrationMapper administrationMapper;

    @Override
    public List<Administration> getAllAdministrations() {
        return administrationMapper.selectAdministrations();
    }
}
