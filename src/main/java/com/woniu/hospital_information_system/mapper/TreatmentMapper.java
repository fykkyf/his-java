package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.DTO.TreatmentDTO;
import com.woniu.hospital_information_system.entity.Treatment;
import com.woniu.hospital_information_system.entity.VO.TreatmentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import java.util.List;
@Mapper
public interface TreatmentMapper {
    //查询所有项目明细(可条件查询()，也可查所有 )根据项目名称和厂家名称查询
    List<TreatmentVO> selectAllTreatment(TreatmentDTO treatmentDTO);

    //根据国家药品编码查询药品是否存在
    List<TreatmentVO> selectAllByCode(TreatmentDTO treatmentDTO);

    //如果不存在 添加新的药品 默认启用1 类型药品0
    void addTreatment(TreatmentDTO treatmentDTO);

    //药品如果存在，只增加库存
    @Update("update treatment set storage=storage+#{storage} where drug_code=#{drugCode}")
    void updateStorage(TreatmentDTO treatmentDTO);

    //药品近期查询
    @Select("select * from treatment where expired_time between  date_add(#{expiredTime1},interval -10 day) and #{expiredTime1}")
    List<TreatmentVO> selectAllTreatmentByExptime(TreatmentDTO treatmentDTO);

    //医生下达医嘱，减少库存
    @Update("update treatment set storage=storage-#{storage} where drug_code=#{drugCode}")
    void reduceStorage(TreatmentDTO treatmentDTO);

    //修改项目信息
    @Update("update treatment set  treatment_name=#{treatmentName}, drug_code=#{drugCode}, manufacturer=#{manufacturer}," +
            " production_time=#{productionTime},expired_time=#{expiredTime}, storage=#{storage}, " +
            "specification=#{specification}, treatment_price=#{treatmentPrice}, insurance_price=#{insurancePrice}," +
            "treatment_status=#{drugCode} where treatment_id=#{treatmentId}")
    void updateTreatment(TreatmentDTO treatmentDTO);

    //根据项目id查询项目
    @Select("select * from treatment where treatment_id = #{treatmentId}")
    Treatment selectTreatmentByTreatmentId(Integer treatmentId);
}
