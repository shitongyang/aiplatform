package com.iscas.aiplatform.entity;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;


/**
 * @Author yangshitong
 * 向前端返回信息封装
 * @param <T> 可变类型
 */
@Getter
@Setter
@AllArgsConstructor
public class Result<T> {
    /**
     * 返回信息
     */
    private String msg;

    /**
     * 数据是否正常请求
     */
    private boolean success;

    /**
     * 具体返回的数据
     */
    private T detail;


   public Result(String msg,boolean success){
      this.msg=msg;
      this.success=success;
    }

    public Result(){

    }

    @Override
    public String toString() {
        return "Result{" +
                "msg='" + msg + '\'' +
                ", success=" + success +
                ", detail=" + detail +
                '}';
    }

    public static String jsonErrorResult(String area){

        HashMap<String,Object> map=new HashMap<>();
        map.put("描述:","输入的数据不是json格式的字符串");
        map.put("你输入的参数是:",area);
        return JSON.toJSONString(map);
    }
}
