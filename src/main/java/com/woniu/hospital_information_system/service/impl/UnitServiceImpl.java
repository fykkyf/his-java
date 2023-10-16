package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.Unit;
import com.woniu.hospital_information_system.mapper.UnitMapper;
import com.woniu.hospital_information_system.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {
    @Autowired
    UnitMapper unitMapper;
    @Override
    public List<Unit> getAllUnits() {
        return unitMapper.getAllUnits();
    }

    @Override
    public void add(Unit unit) {
        unitMapper.add(unit);
    }

    @Override
    public void update(Unit unit) {
        unitMapper.update(unit);
    }

    @Override
    public void removeUnit(int unitId) {
        unitMapper.remove(unitId);
    }
}
