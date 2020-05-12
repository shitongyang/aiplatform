package com.iscas.aiplatform.utils;

import com.alibaba.fastjson.serializer.ValueFilter;

/**
 * @Author yangshitong
 * @Date 2020/5/12 18:43
 * @Version 1.0
 * @Description:  将Object转化为JSON的过程中将null转化为空字符串
 */

public class JSONFilter {
    public static ValueFilter filter = new ValueFilter() {
        @Override
        public Object process(Object obj, String s, Object v) {
            if (v == null) {
                return "";
            } else {
                return v;
            }
        }
    };
}
