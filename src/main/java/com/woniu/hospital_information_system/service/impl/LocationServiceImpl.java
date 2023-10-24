package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.Location;
import com.woniu.hospital_information_system.mapper.LocationMapper;
import com.woniu.hospital_information_system.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationMapper locationMapper;

    /*
    * 获取全部床位信息
    * */
    @Override
    public List<Location> getAllLocation() {
        return locationMapper.selectLocations();
    }

    /*
    * 根据床位状态获取床位信息
    * */
    @Override
    public List<Location> getLocationByStatus(int status) {
        return locationMapper.selectLocationsByStatus(status);
    }

    /*
    * 根据LocationId修改床位信息
    * */
    @Override
    public void modifyLocationStatusByLocationId(int locationId) {
        locationMapper.updateLocationStatus(locationId);
    }

    @Override
    public void updateLocationStatusEmpty(Integer locationId) {
        locationMapper.updateLocationStatusEmpty(locationId);
    }

    @Override
    public void updateLocation(Location location) {
        locationMapper.updateLocation(location);
    }

    @Override
    public void removeLocation(Integer locationId) {
        locationMapper.removeLocation(locationId);
    }

    @Override
    public void addNewLocation(Location location) {
        locationMapper.addNewlocation(location);
    }




}
