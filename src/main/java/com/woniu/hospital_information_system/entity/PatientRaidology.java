package com.woniu.hospital_information_system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
//住院检查表
public class PatientRaidology {
    private Integer patientRaidologyId;
    private Integer patientId;
    private Integer treatmentId;
    private String path;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime testDate;
    private Integer testStatus;
}
