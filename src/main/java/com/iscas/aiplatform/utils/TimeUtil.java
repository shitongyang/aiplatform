package com.iscas.aiplatform.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author yangshitong
 * @Date 2020/5/20 16:58
 * @Version 1.0
 * @Description:  时间格式工具类
 */

public class TimeUtil {

    /**
     * author: YangShiTong
     * description: 获取yyyy-MM-dd HH:mm格式的时间
     * @params
     * @date 2020/7/1 9:53
     * @return
     */
    public static String getCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date=new Date();
        String time=sdf.format(date);
        return time;
    }

}
