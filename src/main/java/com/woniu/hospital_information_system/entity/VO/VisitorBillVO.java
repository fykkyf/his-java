package com.woniu.hospital_information_system.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VisitorBillVO {
    private Integer visitorBillId;
    private Integer visitorId;
    private Integer treatmentId;
    private String treatmentName;
    private Integer drugCount;
    private Double treatmentPrice;
    private Integer paymentStatus;
}
