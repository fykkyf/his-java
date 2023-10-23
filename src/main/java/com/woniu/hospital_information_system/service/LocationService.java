package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.Location;

import java.util.List;

public interface LocationService {
    //获取全部床位
    List<Location> getAllLocation();
    //通过床位状态获取床位信息
    List<Location> getLocationByStatus(int status);
    //添加床位
    void modifyLocationStatusByLocationId(int locationId);
    //清空床位
    void updateLocationStatusEmpty(Integer locationId);


    void updateLocation(Location location);

    void removeLocation(Integer locationId);

    void addNewLocation(Location location);
}
