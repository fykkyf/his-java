package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.PatientBill;
import com.woniu.hospital_information_system.entity.VO.PatientBillResultVO;
import com.woniu.hospital_information_system.entity.VO.PatientBillVO;

import java.util.List;

public interface PatientBillService {


    PatientBillResultVO getPatientBillVO(Integer patientId);

    void billPaymentStatus(Integer patientBillId);

    Double getPaymentSum(List<PatientBillVO> patientBillVOList);

    List<Integer> getAllBillIds(Integer patientId);


    void modifyManipulateStatusByBillId(Integer patientBillId);
}
