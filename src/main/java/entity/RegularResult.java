package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegularResult {
    private Integer regularTestId;
    private Integer patientId;
    private Integer pressure;
    private Double sugar;
    private Double temp;
    private Date testDate;
}
