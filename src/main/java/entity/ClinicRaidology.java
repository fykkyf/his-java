package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClinicRaidology {
    private Integer clinicRaidologyId;
    private Integer visitorId;
    private Integer treatmentId;
    private String path;
    private Date testDate;
    private Integer testStatus;
}
