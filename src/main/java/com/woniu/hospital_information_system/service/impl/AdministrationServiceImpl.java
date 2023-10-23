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

    @Override
    public void addAdministration(Administration administration) {
        administrationMapper.addAdministration(administration);
    }

    @Override
    public void updateAdministration(Administration administration) {
        administrationMapper.updateAdministration(administration);
    }

    @Override
    public void removeAdministration(int administrationId) {
        administrationMapper.deleteAdministration(administrationId);
    }
}
