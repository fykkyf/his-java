package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.DTO.PatientRaidologyDTO;
import com.woniu.hospital_information_system.entity.PatientRaidology;
import com.woniu.hospital_information_system.entity.VO.PatientRaidologyVO;
import com.woniu.hospital_information_system.entity.VisitorInfo;

import java.util.List;

public interface PatientRaidologyService {

    void addPicture(String path, String fileName,Integer patientRaidologyId);

    String getPictureFileName(VisitorInfo visitorInfo);

    void addPatientRaidology(Integer patientId,Integer treatmentId);

    List<PatientRaidologyVO> getAllPatientRadio();

    List<PatientRaidologyVO> getAllPatientRadioByKeyWord(PatientRaidologyDTO patientRaidologyDTO);
}
