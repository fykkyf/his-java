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
public class PatientRaidologyVO {
    private Integer patientRaidologyId;
    private Integer patientId;
    private String patientName;
    private Integer patientBillId;
    private Integer treatmentId;
    private String treatmentName;
    private String unitName;
    private String employeeName;
    private String path;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime testDate;
    private Integer teatStatus;
    private String fileName;
}
