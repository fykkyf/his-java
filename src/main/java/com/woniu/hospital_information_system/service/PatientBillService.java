package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.PatientBill;
import com.woniu.hospital_information_system.entity.VO.PatientBillVO;

import java.util.List;

public interface PatientBillService {


    List<PatientBillVO> getPatientBillVO(Integer patientId);
}
