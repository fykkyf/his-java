package com.woniu.hospital_information_system.entity.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientLabVO {
    private Integer patientLabId;
    private Integer patientId;
    private Integer patientBillId;
    private String patientName;
    private String unitName;
    private String employeeName;
    private Integer treatmentId;
    private String treatmentName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date testDate;
    private String labResult;
    private Integer testStatus;
}
