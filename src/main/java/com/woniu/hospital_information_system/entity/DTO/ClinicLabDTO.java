package com.woniu.hospital_information_system.entity.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
//门诊检验表
public class ClinicLabDTO {
    private Integer clinicLabId;
    private Integer visitorId;
    private Integer treatmentId;
    private Integer visitorBillId;
    private String labResult;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date testDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date testDate1;
    private Integer testStatus;
}
