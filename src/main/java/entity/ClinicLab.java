package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClinicLab {
    private Integer clinicLabId;
    private Integer visitorId;
    private Integer treatmentId;
    private String labResult;
    private Date testDate;
    private Integer testStatus;
}
