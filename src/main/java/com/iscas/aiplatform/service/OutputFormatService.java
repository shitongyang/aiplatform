package com.iscas.aiplatform.service;

/**
 * @Author yangshitong
 * @Date 2020/5/12 14:52
 * @Version 1.0
 * @Description:进行样本的分享和取消分享,主要是操作output_format表
 */

public interface OutputFormatService {
    String shareSample(int id);
    //分享样本数据

    String cancelShareSample(int id);
    //取消分享样本数据

    String addOutputFormat(String path,String describe,String username,String faultSet);
    //向样本输出格式表里添加记录

    String showSampleByName(String username);
    //根据用户名字展示样本数据
}
