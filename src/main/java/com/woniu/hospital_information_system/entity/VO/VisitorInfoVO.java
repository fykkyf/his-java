package com.woniu.hospital_information_system.entity.VO;

import com.woniu.hospital_information_system.entity.PatientInfo;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorInfoVO {
    private List<VisitorInfo> visitorInfoList;
    private Integer pageSize;
    private Integer pageNum;
    private Integer total;
}
