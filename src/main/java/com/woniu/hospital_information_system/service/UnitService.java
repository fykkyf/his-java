package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.Unit;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UnitService {
    List<Unit> getAllUnits();
}
