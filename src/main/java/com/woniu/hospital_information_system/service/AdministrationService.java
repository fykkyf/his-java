package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.Administration;

import java.util.List;

public interface AdministrationService {
    List<Administration> getAllAdministrations();

    void addAdministration(Administration administration);

    void updateAdministration(Administration administration);

    void removeAdministration(int administrationId);
}
