package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//医保疾病表
public class Disease {
    private Integer diseaseId;
    private String diseaseName;
}
