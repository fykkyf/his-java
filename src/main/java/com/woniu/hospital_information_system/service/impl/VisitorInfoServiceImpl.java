package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.*;
import com.woniu.hospital_information_system.entity.DTO.VisitorInfoDTO;
import com.woniu.hospital_information_system.mapper.*;
import com.woniu.hospital_information_system.service.VisitorBillService;
import com.woniu.hospital_information_system.service.VisitorInfoService;
import com.woniu.hospital_information_system.util.NowTime;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class VisitorInfoServiceImpl implements VisitorInfoService {
    @Autowired
    VisitorInfoMapper visitorInfoMapper;
    @Autowired
    VisitorBillMapper visitorBillMapper;
    @Autowired
    VisitorBillService visitorBillService;
    @Autowired
    DiseaseMapper diseaseMapper;
    @Autowired
    TreatmentMapper treatmentMapper;
    @Autowired
    ClinicRaidologyMapper clinicRaidologyMapper;




    @Transactional
    @Override
    @Options(useGeneratedKeys = true, keyColumn = "visitor_id", keyProperty = "visitorId")
    public void addVisitorInfo(VisitorInfo visitorInfo) {
        /*
        挂号成功的同时,生成门诊患者费用表
         */
        visitorInfoMapper.addVisitorInfo(visitorInfo);//添加患者信息
        Integer treatmentId = visitorBillMapper.getTreatmentId(visitorInfo.getEmployee().getEmployeeId());//得到项目id
        Double treatmentPrice = visitorBillMapper.getPriceByTreatmentId(treatmentId);//得到挂号的那个医生的费用
        visitorBillService.addVisitorBillByVisitorIdAndEmployeeId(visitorInfo.getVisitorId(),treatmentId,treatmentPrice);//在门诊患者费用表中生成数据
    }

    @Override
    public VisitorInfo getVisitorInfoByVisitorId(Integer visitorId) {
        return visitorInfoMapper.getVisitorInfoByVisitorId(visitorId);
    }

    @Override
    public List<VisitorInfo> getVisitorInfoByPaySuccess() {
        return visitorInfoMapper.getVisitorInfoByPaySuccess();
    }

    @Override
    public void updateClinicStatus(Integer visitorId) {
        visitorInfoMapper.updateClinicStatus(visitorId);
    }

    @Override
    public VisitorInfo getVisitingByVisitorId(Integer visitorId) {
        return visitorInfoMapper.getVisitingByVisitorId(visitorId);
    }

    @Override
    public void updateClinicStatusAfterVisiting(VisitorInfo visitorInfo) {
        visitorInfoMapper.updateClinicStatusAfterVisiting(visitorInfo);
    }

    @Override
    public void updateDisease(VisitorInfo visitorInfo) {
        visitorInfoMapper.updateDisease(visitorInfo);
    }



//    @Override
//    public List<VisitorInfo> getAll() {
//        return visitorInfoMapper.getAll();
//    }

    @Override
    public List<VisitorInfo> getVisitorByEmployeeId(Integer eid) {
        return visitorInfoMapper.getVisitorByEmployeeId(eid);
    }

    @Override
    public void updateMessage(VisitorInfo visitorInfo) {
        visitorInfoMapper.updateMessage(visitorInfo);
    }

    @Transactional
    @Override
    public List<VisitorInfoDTO> getVisitorInfoIdByPaySuccessAndManipulateStatus() {
        VisitorInfoDTO visitorInfoDTO = new VisitorInfoDTO();
        List<VisitorInfoDTO> allVisitorDTO=new ArrayList<>();
        //先从检查表查出,状态为1的未检查
        List<ClinicRaidology> noChecks = clinicRaidologyMapper.getNoCheck();
        for (ClinicRaidology noCheck:noChecks) {
            //得到检查单号
            Integer clinicRaidologyId = noCheck.getClinicRaidologyId();
            //得到病人id
            Integer visitorId = noCheck.getVisitorId();
            //通过病人id，查出病人信息
            VisitorInfo visByVid = visitorInfoMapper.getVisByVid(visitorId);
            //得到项目id
            Integer treatmentId = noCheck.getTreatmentId();
            //等到项目名称
            Treatment treatmentNameById = treatmentMapper.getTreatmentNameById(treatmentId);
            //封装到visitorInfoDTO中
            visitorInfoDTO.setClinicRaidologyId(clinicRaidologyId);
            visitorInfoDTO.setVisitorInfo(visByVid);
            visitorInfoDTO.setTreatment(treatmentNameById);
            if (!allVisitorDTO.contains(visitorInfoDTO)) {
                    allVisitorDTO.add(visitorInfoDTO);
                }
        }
        return allVisitorDTO;
//        VisitorInfoDTO visitorInfoDTO = new VisitorInfoDTO();
//        List<VisitorInfoDTO> allVisitorDTO=new ArrayList<>();
//        //通过项目状态为4，查出其项目id
//        List<Integer> treatmentIds=treatmentMapper.getExamine();
//        for (Integer tid: treatmentIds) {
//            //项目id到门诊费用表中，查出已支付，未完成的门诊id
//            List<VisitorBill> visitorBills = visitorInfoMapper.getVisitorInfoIdByPaySuccessAndManipulateStatus(tid);
//            for (VisitorBill vb : visitorBills) {
//                Integer visitorId = vb.getVisitorId();
//                //再用门诊id得到患者姓名，性别
//                VisitorInfo visByVid = visitorInfoMapper.getVisByVid(visitorId);
//                //得到项目名称
//                Integer treatmentId = vb.getTreatmentId();
//                String treatmentNameById = treatmentMapper.getTreatmentNameById(treatmentId);
//                visitorInfoDTO.setVisitorInfo(visByVid);
//                visitorInfoDTO.setTreatmentName(treatmentNameById);
//                if (!allVisitorDTO.contains(visitorInfoDTO)) {
//                    allVisitorDTO.add(visitorInfoDTO);
//                }
//            }
//        }
//        return allVisitorDTO;
    }

    @Override
    public List<VisitorInfo> getByCondition(VisitorInfo visitorInfo) {
        return visitorInfoMapper.getByCondition(visitorInfo);
    }

    /*
    *   查询病人疾病信息
    * */
    @Override
    public Disease getDiagnosisByVisitorId(Integer visitorId) {
        return diseaseMapper.selectDiseaseById(visitorInfoMapper.getVisitorInfoByVisitorId(visitorId).getClinicDiagnosis().getDiseaseId());
    }


}
