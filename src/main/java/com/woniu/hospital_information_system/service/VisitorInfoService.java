package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.VisitorInfo;

public interface VisitorInfoService {
    void addVisitorInfo(VisitorInfo visitorInfo);

    VisitorInfo getVisitorInfoByVisitorId(Integer visitorId);
}
