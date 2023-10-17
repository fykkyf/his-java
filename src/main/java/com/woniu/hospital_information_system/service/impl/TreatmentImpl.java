package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.DTO.TreatmentDTO;
import com.woniu.hospital_information_system.entity.VO.TreatmentVO;
import com.woniu.hospital_information_system.mapper.TreatmentMapper;
import com.woniu.hospital_information_system.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentImpl implements TreatmentService {

    @Autowired
    TreatmentMapper treatmentMapper;
    //查询所有项目明细(可条件查询，也可查所有)
    @Override
    public List<TreatmentVO> selectAllTreatment(TreatmentDTO treatmentDTO) {
        return treatmentMapper.selectAllTreatment(treatmentDTO);
    }


    @Override
    public List<TreatmentVO> selectAllByCode(TreatmentDTO treatmentDTO) {
        return treatmentMapper.selectAllByCode(treatmentDTO);
    }

    @Override
    public void addTreatment(TreatmentDTO treatmentDTO) {
        treatmentMapper.addTreatment(treatmentDTO);
    }

    @Override
    public void updateStorage(TreatmentDTO treatmentDTO) {
        treatmentMapper.updateStorage(treatmentDTO);
    }

    @Override
    public void updateTreatment(TreatmentDTO treatmentDTO) {
        treatmentMapper.updateTreatment(treatmentDTO);
    }

    @Override
    public void reduceStorage(TreatmentDTO treatmentDTO) {
        treatmentMapper.reduceStorage(treatmentDTO);
    }
}
