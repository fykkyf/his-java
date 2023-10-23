package com.woniu.hospital_information_system.entity.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
//项目明细表
public class TreatmentVO {
    private Integer treatmentId;
    private String treatmentName;
    private String manufacturer;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime productionTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime expiredTime;
    private Integer storage;
    private String specification;
    private Double treatmentPrice;
    private Double insurancePrice;
    private Integer treatmentStatus;
    private Integer treatmentCategory;
    private Integer drugCode;
    private Integer pageNum;
    private Integer pageSize;
}
