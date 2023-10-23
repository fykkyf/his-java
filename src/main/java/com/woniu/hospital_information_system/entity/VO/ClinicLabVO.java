package com.woniu.hospital_information_system.entity.VO;

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
public class ClinicLabVO {
    private Integer clinicLabId;
    private Integer visitorId;
    private Integer treatmentId;
    private Integer visitorBillId;
    private String labResult;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date testDate;
    private Integer testStatus;

    private String visitorName;
    private String unitName;
    private String employeeName;
    private String treatmentName;

}
