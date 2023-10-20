package com.woniu.hospital_information_system.entity.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.woniu.hospital_information_system.entity.PatientOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//住院医嘱表
public class PatientOrderVO {
    private List<PatientOrder> patientOrders;
    private Integer pageNum;
    private Integer pageSize;
    private Integer total;
}
