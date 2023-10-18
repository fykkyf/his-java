package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.DTO.OmdDTO;
import com.woniu.hospital_information_system.entity.DTO.TreatmentDTO;
import com.woniu.hospital_information_system.entity.Treatment;
import com.woniu.hospital_information_system.entity.VO.OmdVO;
import com.woniu.hospital_information_system.entity.VO.TreatmentVO;
import org.apache.ibatis.annotations.*;


import java.util.List;
@Mapper
public interface TreatmentMapper {
    //查询所有项目明细(可条件查询()，也可查所有 )根据项目名称和厂家名称查询
    List<TreatmentVO> selectAllTreatment(TreatmentDTO treatmentDTO);

    //根据国家药品编码查询药品是否存在
    List<TreatmentVO> selectAllByCode(TreatmentDTO treatmentDTO);

    //如果不存在 添加新的药品 默认启用1 类型药品1
    void addTreatment(TreatmentDTO treatmentDTO);

    //药品如果存在，只增加库存
    @Update("update treatment set storage=storage+#{storage} where drug_code=#{drugCode}")
    void updateStorage(TreatmentDTO treatmentDTO);

    //药品近期查询
    @Select("select * from treatment where expired_time between  date_add(#{expiredTime},interval -10 day) and #{expiredTime}")
    List<TreatmentVO> selectAllTreatmentByExptime(TreatmentDTO treatmentDTO);

    //近期药品处理，减少库存
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

    //管理员添加项目明细，根据项目名称查询
    @Select("select * from treatment where treatment_name = #{treatmentName}")
    TreatmentVO selectTreatmentByName(TreatmentDTO treatmentDTO);
    //如果根据名称没有查到，管理员添加项目明细
    @Insert("insert into treatment (treatment_id,treatment_name,treatment_price,insurance_price,treatment_status,treatment_category) " +
            "values (null,treatmentName,treatmentPrice,insurancePrice,1,treatmentCategory,)")
    void addTreatment1(TreatmentDTO treatmentDTO);

    //门诊发药查询(根据已发药、未发药、发药日期、病人就诊号 支付状态：待定)
    List<OmdVO> selectOmd(OmdDTO omdDTO);

    //门诊发药操作 根据费用ID，修改门诊病人费用表中的操作状态码  根据医嘱ID插入发药时间
    void updateMsById(@Param("vbids") List<Integer> vbids);

    void updateDtById(@Param("coids")  List<Integer> coids);

    //门诊发药，根据项目ID减少库存
    @Update("update treatment set storage =storage-#{drugCount} where drug_code=drugCode")
    void updatestorageById(OmdVO omdVO);



}
