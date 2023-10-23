package com.woniu.hospital_information_system.entity.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImdVO {
    private Integer patientId;
    private String patientName;
    private Integer patientBillId;
    private Integer gender;
    private String unitName;
    private String employeeName;
    private Integer drugCode;
    private String treatmentName;
    private Integer drugCount;
    private String specification;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dispenseTime;

}
