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
}
