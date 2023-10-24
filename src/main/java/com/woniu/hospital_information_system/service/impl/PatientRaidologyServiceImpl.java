package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.DTO.PatientRaidologyDTO;
import com.woniu.hospital_information_system.entity.PatientRaidology;
import com.woniu.hospital_information_system.entity.VO.PatientRaidologyVO;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.mapper.PatientRaidologyMapper;

import com.woniu.hospital_information_system.service.PatientRaidologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientRaidologyServiceImpl implements PatientRaidologyService {
    @Autowired
    PatientRaidologyMapper patientRaidologyMapper;

    @Override
    public void addPicture(String path, String fileName,Integer patientRaidologyId) {
        patientRaidologyMapper.addPicture(path,fileName,patientRaidologyId);
    }

    @Override
    public String getPictureFileName(Integer patientId) {
        return patientRaidologyMapper.getPictureFileName(patientId);
    }

    @Override
    public void addPatientRaidology(Integer patientId, Integer treatmentId) {
        patientRaidologyMapper.insertPatientRaidology(patientId,treatmentId);
    }
    /*
    * 查询所有检查信息
    * */
    @Override
    public List<PatientRaidologyVO> getAllPatientRadio() {
        return patientRaidologyMapper.selectAllPatientRaido();
    }
    /*
     * 模糊查询
     * */
    @Override
    public List<PatientRaidologyVO> getAllPatientRadioByKeyWord(PatientRaidologyDTO patientRaidologyDTO) {
        return patientRaidologyMapper.selectPatientRaidosByKeyWord(patientRaidologyDTO);
    }



}
