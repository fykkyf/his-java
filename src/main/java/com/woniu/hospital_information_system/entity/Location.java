package com.woniu.hospital_information_system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//床位表
public class Location {
    private Integer locationId;
    private String locationName;
    private Integer locationStatus;
}
