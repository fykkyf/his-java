package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientLab {
    private Integer patientLabId;
    private Integer patientId;
    private Integer treatmentId;
    private String labResult;
    private Date testDate;
    private Integer testStatus;
}
