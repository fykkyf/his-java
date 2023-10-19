package com.woniu.hospital_information_system.entity.DTO;

import cn.hutool.core.date.DateTime;
import com.woniu.hospital_information_system.entity.Treatment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientOrderDTO {
    private Integer patientOrderId;
    private Integer patientId;
    private Integer doctorId;
    private List<TreatmentDTO> treatments;
    private Integer administrationId;
    private Integer dosageId;
    private Integer treatmentCount;
    private DateTime executionTime;
    private DateTime dispenseTime;
    private Integer executionStatus;
    private Integer orderType;
    private Integer admissionDiagnosisId;
    private Integer dischargeDiagnosisId;
}
