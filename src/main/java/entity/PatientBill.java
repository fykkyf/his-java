package entity;


import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//住院患者费用表
public class PatientBill {

    private Integer patientBillId;
    private Integer patientId;
    private Integer treatmentId;
    private Integer drugCount;
    private Double treatmentPrice;
    private DateTime orderDate;
    private DateTime paymentDate;
    private Integer paymentStatus;
    private Integer manipulateStatus;
}
