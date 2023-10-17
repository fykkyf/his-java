package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.VisitorInfo;

import java.util.List;

public interface VisitorInfoService {
    void addVisitorInfo(VisitorInfo visitorInfo);

    VisitorInfo getVisitorInfoByVisitorId(Integer visitorId);

    List<VisitorInfo> getVisitorInfoByPaySuccess();

    void updateClinicStatus(Integer visitorId);

    VisitorInfo getVisitingByVisitorId(Integer visitorId);

    void updateClinicStatusAfterVisiting(VisitorInfo visitorInfo);

    void updateDisease(VisitorInfo visitorInfo);
}
