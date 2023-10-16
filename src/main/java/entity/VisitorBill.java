package entity;

import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/*
* 门诊患者费用表
* */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorBill {
    private Integer visitorBillId;
    private Integer visitorId;
    private Integer treatmentId;
    private Integer drugId;
    private BigDecimal treatmentPrice;
    private DateTime orderDate;
    private DateTime paymentDate;
    private Integer paymentStatus;
    private Integer manipulateStatus;
}
