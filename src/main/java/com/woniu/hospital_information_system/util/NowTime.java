package com.woniu.hospital_information_system.util;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/*
封装的获取当前datetime的方法
 */
@Component
public class NowTime {
    public Timestamp getNow(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(date);
        Timestamp now = Timestamp.valueOf(nowTime);
        return now;
    }
}
