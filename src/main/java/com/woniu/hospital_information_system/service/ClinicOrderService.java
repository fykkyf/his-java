package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.ClinicOrder;
import com.woniu.hospital_information_system.entity.DTO.ClinicOrderDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface ClinicOrderService {



    void addClinicOrder(ClinicOrderDTO clinicOrderDTO);
}
