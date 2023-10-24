package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.VisitorInfo;

public interface ClinicRaidologyService {

    void addPicture(String path, String fileName,Integer clinicRaidologyId);


    String getPictureFileName(Integer visitorId);
}
