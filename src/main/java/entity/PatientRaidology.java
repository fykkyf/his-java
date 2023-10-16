package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
//住院检查表
public class PatientRaidology {
    private Integer patientRaidologyId;
    private Integer patientId;
    private Integer treatmentId;
    private String path;
    private Date testDate;
    private Integer testStatus;
}
