package com.woniu.hospital_information_system.entity.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.woniu.hospital_information_system.entity.Treatment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClinicOrderDTO {
    private Integer clinicOrderId;
    private Integer visitorId;
    private Integer doctorId;
    private Integer treatmentId;
    private String treatmentName;
    private Integer administrationId;
    private Integer dosageId;
    private Integer treatmentCount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime executionTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dispenseTime;
    private Treatment treatment;
}
