package com.woniu.hospital_information_system.entity.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
//门诊发药
public class OmdDTO {
    private Integer manipulateStatus;
    private Integer visitorId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date executionTime;
}
