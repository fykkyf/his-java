package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.VisitorInfo;

public interface PatientRaidologyService {

    void addPicture(String path, String fileName,Integer patientRaidologyId);

    String getPictureFileName(VisitorInfo visitorInfo);

    void addPatientRaidology(Integer patientId,Integer treatmentId);
}
