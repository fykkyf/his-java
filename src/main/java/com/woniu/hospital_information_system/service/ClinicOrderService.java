package com.woniu.hospital_information_system.service;

import com.woniu.hospital_information_system.entity.ClinicOrder;
import com.woniu.hospital_information_system.entity.DTO.ClinicOrderDTO;
import com.woniu.hospital_information_system.entity.VO.ClinicOrderVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ClinicOrderService {



    void addClinicOrder(ClinicOrderDTO clinicOrderDTO);

    List<ClinicOrderVO> getOrderByVisitorId(Integer visitorId);

}
