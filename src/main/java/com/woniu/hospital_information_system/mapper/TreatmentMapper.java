package com.woniu.hospital_information_system.mapper;

import com.woniu.hospital_information_system.entity.DTO.ImdDTO;
import com.woniu.hospital_information_system.entity.DTO.OmdDTO;
import com.woniu.hospital_information_system.entity.DTO.TreatmentDTO;
import com.woniu.hospital_information_system.entity.Treatment;
import com.woniu.hospital_information_system.entity.VO.ImdVO;
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
    @Select("select * from treatment where expired_time between #{expiredTime} and date_add(#{expiredTime},interval 10 day) ")
    List<TreatmentVO> selectAllTreatmentByExptime(TreatmentDTO treatmentDTO);

    //近期药品处理，减少库存
    @Update("update treatment set storage=storage-#{storage1} where drug_code=#{drugCode}")
    void reduceStorage(TreatmentDTO treatmentDTO);
    //药品入库
    @Update("update treatment set storage=storage+#{storage1} where drug_code=#{drugCode}")
    void warehousing(TreatmentDTO treatmentDTO);

    //修改药品信息
    @Update("update treatment set  treatment_name=#{treatmentName}, drug_code=#{drugCode}, manufacturer=#{manufacturer}," +
            " production_time=#{productionTime},expired_time=#{expiredTime}, storage=#{storage}, " +
            "specification=#{specification}, treatment_price=#{treatmentPrice}, insurance_price=#{insurancePrice}," +
            "treatment_status=#{treatmentStatus} where treatment_id=#{treatmentId}")
    void updateTreatment(TreatmentDTO treatmentDTO);

    //根据项目id查询项目
    @Select("select * from treatment where treatment_id = #{treatmentId}")
    Treatment selectTreatmentByTreatmentId(Integer treatmentId);

    //管理员添加项目明细，根据项目名称查询
    @Select("select * from treatment where treatment_name = #{treatmentName}")
    TreatmentVO selectTreatmentByName(TreatmentDTO treatmentDTO);
    //如果根据名称没有查到，管理员添加项目明细
    @Insert("insert into treatment (treatment_id,treatment_name,treatment_price,insurance_price,treatment_status,treatment_category) " +
            "values (null,#{treatmentName},#{treatmentPrice},#{insurancePrice},1,#{treatmentCategory})")
    void addTreatment1(TreatmentDTO treatmentDTO);

    //门诊发药查询汇总、根据下单日期(前端默认当天日期)/门诊就诊ID(可传) 查询需要发药的患者ID和姓名
    List<OmdVO> selectVisitorByOmd(OmdDTO omdDTO);

    //门诊发药查询明细(根据未发药、病人就诊号 可选:发药日期 前端默认当天  支付状态：待定)
    List<OmdVO> selectOmd(OmdDTO omdDTO);

    //门诊发药操作 根据费用ID，修改门诊病人费用表中的操作状态码  插入发药时间
    void updateMsById(@Param("vbids") List<Integer> vbids);



    //门诊发药，根据项目ID减少库存
    @Update("update treatment set storage =storage-#{drugCount} where drug_code=#{drugCode}")
    void updatestorageById(OmdVO omdVO);



    //住院发药查询汇总、根据记账日期(前端默认当天日期)/住院ID(可传) 查询需要发药的患者ID和姓名
    List<ImdVO> selectPatientByImd(ImdDTO imdDTO);

    //住院发药查询明细(根据未发药、病人住院号 可选:发药日期 前端默认当天  记账状态：已记账)
    List<ImdVO> selectImd(ImdDTO imdDTO);

    //住院发药操作 根据费用ID，修改住院病人费用表中的操作状态码  插入发药时间
    void updatePbById(@Param("pbids") List<Integer> pbids);
    //住院发药，根据项目ID减少库存
    @Update("update treatment set storage =storage-#{drugCount} where drug_code=#{drugCode}")
    void updatestorageByImId(ImdVO imdVO);

    @Select("select * from treatment where treatment_id=#{treatmentId}")
    Treatment getTreatmentNameById(Integer treatmentId);
    //门诊已经发药查询汇总、根据下单日期(前端默认当天日期)/门诊就诊ID(可传) 查询需要发药的患者ID和姓名
    List<OmdVO> selectClinicMed(OmdDTO omdDTO);

    //门诊已经发药查询明细(根据未发药、病人就诊号 可选:发药日期 前端默认当天  支付状态：待定)
    List<OmdVO> selectClinicMedmx(OmdDTO omdDTO);

    //住院已经发药查询汇总、根据记账日期(前端默认当天日期)/住院ID(可传) 查询需要发药的患者ID和姓名
    List<ImdVO> selectPatientMed(ImdDTO imdDTO);
    //住院已经发药查询明细、根据记账日期(前端默认当天日期)/住院ID(可传) 查询需要发药的患者ID和姓名
    List<ImdVO> selectPatientMedmx(ImdDTO imdDTO);

    //查询所有非药品明细
    List<TreatmentVO> selectAllTreatments(TreatmentDTO treatmentDTO);

    @Select("select treatment_id from treatment where treatment_category=4")
    List<Integer> getExamine();
}
