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
 * @Description:  时间格式转化的测试
 */

public class TimeUtil {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date=new Date();
        System.out.println(sdf.format(date));

        System.out.println(System.currentTimeMillis());

        int daysOfThisYear = LocalDate.now().lengthOfYear();
        int daysOfYear = LocalDate.of(2024, 1, 1).lengthOfYear();
        System.out.println(daysOfYear);

        List<String> list = new ArrayList<>(2);
        list.add("guan");
        list.add("bao");
        String[] array = list.toArray(new String[0]);
        method(null);
    }
    public static void method(String param) {
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }
    }
}
