package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.mapper.VisitorInfoMapper;
import com.woniu.hospital_information_system.service.VisitorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorInfoServiceImpl implements VisitorInfoService {
    @Autowired
    VisitorInfoMapper visitorInfoMapper;

    @Override
    public void addVisitorInfo(VisitorInfo visitorInfo) {
        visitorInfoMapper.addVisitorInfo(visitorInfo);
    }

    @Override
    public VisitorInfo getVisitorInfoByVisitorId(Integer visitorId) {
        return visitorInfoMapper.getVisitorInfoByVisitorId(visitorId);
    }
}
