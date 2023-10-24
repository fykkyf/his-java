package com.woniu.hospital_information_system.entity.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
//项目明细表
public class TreatmentDTO {
    private Integer treatmentId;
    private String treatmentName;
    private Integer treatmentCount;
    private String manufacturer;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date productionTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expiredTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date expiredTime1;
    private Integer storage;
    private Integer storage1;//药品出库  所出库的数量
    private String specification;
    private Double treatmentPrice;
    private Double insurancePrice;
    private Integer treatmentStatus;
    private Integer treatmentCategory;
    private  String keyword;
    private Integer drugCode;

    private Integer pageNum;
    private Integer pageSize;
}
