package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.Dosage;

import java.util.List;

public interface DosageService {
    List<Dosage> getAllDosages();

    void addDosage(Dosage dosage);

    void updateDosage(Dosage dosage);

    void removeDosage(Integer dosageId);
}
