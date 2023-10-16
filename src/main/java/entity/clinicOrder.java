package entity;

import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* 门诊医嘱表
* */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class clinicOrder {
    private Integer clinicOrderId;
    private Integer visitorId;
    private Integer doctorId;
    private Integer treatmentId;
    private String treatmentName;
    private Integer administrationId;
    private Integer dosageId;
    private Integer treatmentCount;
    private DateTime executionTime;
    private DateTime dispenseTime;
}
