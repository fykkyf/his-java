package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.mapper.ClinicRaidologyMapper;
import com.woniu.hospital_information_system.service.ClinicRaidologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicRaidologyServiceImpl implements ClinicRaidologyService {
    @Autowired
    ClinicRaidologyMapper clinicRaidologyMapper;

    @Override
    public void addPicture(String path, String fileName,Integer clinicRaidologyId) {
        clinicRaidologyMapper.addPicture(path,fileName,clinicRaidologyId);
    }

    @Override
    public String getPictureFileName(Integer visitorId) {
        System.out.println("这里是service:"+clinicRaidologyMapper.getPictureFileName(visitorId));
        return clinicRaidologyMapper.getPictureFileName(visitorId);
    }
}
