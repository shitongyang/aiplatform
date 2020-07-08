package com.iscas.aiplatform.utils;

import java.util.List;
import java.util.Map;

/**
 * @Author yangshitong
 * @Date 2020/7/1 14:04
 * @Version 1.0
 * @Description: 为返回的数据添加序号
 */

public class AddNoUtil {

    public static List addNo(List paramList){
        /*
         * 加上排列序号
         * 修改is_share字段为布尔类型
         * */
        List<Map<String,Object>> list = paramList;
        int no = 1;
        // 为前端展示加序号
        for (Map m:list) {
            m.put("no",no++);
            // m.put("is_share","0".equals(m.get("is_share"))?false:true);
        }
        return list;
    }
}
