package com.woniu.hospital_information_system.service.impl;

import com.woniu.hospital_information_system.entity.VisitorInfo;
import com.woniu.hospital_information_system.mapper.VisitorBillMapper;
import com.woniu.hospital_information_system.mapper.VisitorInfoMapper;
import com.woniu.hospital_information_system.service.VisitorBillService;
import com.woniu.hospital_information_system.service.VisitorInfoService;
import com.woniu.hospital_information_system.util.NowTime;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class VisitorInfoServiceImpl implements VisitorInfoService {
    @Autowired
    VisitorInfoMapper visitorInfoMapper;
    @Autowired
    VisitorBillMapper visitorBillMapper;
    @Autowired
    VisitorBillService visitorBillService;




    @Transactional
    @Override
    @Options(useGeneratedKeys = true, keyColumn = "visitor_id", keyProperty = "visitorId")
    public void addVisitorInfo(VisitorInfo visitorInfo) {
        /*
        挂号成功的同时,生成门诊患者费用表
         */
        visitorInfoMapper.addVisitorInfo(visitorInfo);//添加患者信息
        System.out.println(visitorInfo.getDoctorId());
        Integer treatmentId = visitorBillMapper.getTreatmentId(visitorInfo.getDoctorId());//得到项目id
        System.out.println("这里是项目id"+treatmentId);
        Double treatmentPrice = visitorBillMapper.getPriceByTreatmentId(treatmentId);//得到挂号的那个医生的费用
        System.out.println("这里是挂号价格："+treatmentPrice);
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

    @Override
    public List<VisitorInfo> getAll() {
        return visitorInfoMapper.getAll();
    }

    @Override
    public List<VisitorInfo> getVisitorByEmployeeId(Integer eid) {
        return visitorInfoMapper.getVisitorByEmployeeId(eid);
    }

    @Override
    public void updateMessage(VisitorInfo visitorInfo) {
        visitorInfoMapper.updateMessage(visitorInfo);
    }
}
