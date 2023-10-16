package com.woniu.hospital_information_system.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
//项目明细表
public class TreatmentVO {
    private Integer treatmentId;
    private String treatmentName;
    private String manufacturer;
    private Date productionTime;
    private Date expiredTime;
    private Integer storage;
    private String specification;
    private Double treatmentPrice;
    private Double insurancePrice;
    private Integer treatmentStatus;
    private Integer treatmentCategory;
}
