package com.woniu.hospital_information_system.entity.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientLabDTO {
    private Integer patientLabId;
    private Integer patientId;
    private Integer patientBillId;
    private String patientName;
    private String unitName;
    private String employeeName;
    private Integer treatmentId;
    private String treatmentName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date testDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date testDate1;
    private String labResult;
    private Integer testStatus;



}
