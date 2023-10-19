package com.woniu.hospital_information_system.entity.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImdDTO {
    private Integer patientId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date orderDate1;

}
