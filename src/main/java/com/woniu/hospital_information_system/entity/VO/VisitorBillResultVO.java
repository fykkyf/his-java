package com.woniu.hospital_information_system.entity.VO;

import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VisitorBillResultVO {
    private List<VisitorBillVO> visitorBillVOList;
    private VisitorInfo visitorInfo;
    private Double finalPrice;

}
