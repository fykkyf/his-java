package com.woniu.hospital_information_system.entity.DTO;


import com.woniu.hospital_information_system.entity.Treatment;
import com.woniu.hospital_information_system.entity.VisitorInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorInfoDTO {
    private Integer clinicRaidologyId;
    private VisitorInfo visitorInfo;
//    private String treatmentName;
    private Treatment treatment;
}
