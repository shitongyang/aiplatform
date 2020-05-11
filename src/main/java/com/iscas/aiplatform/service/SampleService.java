package com.iscas.aiplatform.service;

import java.util.List;

/**
 * @author : lvxianjin
 * @Date: 2020/5/11 08:58
 * @Description:
 */
public interface SampleService {
    /**
     *
     * 功能描述:
     * 1.将LS文件同步更新到公共区域，只允许读
     * 2.样本制造的输入文件有：
     * （1）潮流断面数据
     * （2）故障集
     * （3）输出结果格式文件
     * 3.样本制造的输出文件：
     * （1）对应的时间
     * （2）暂稳计算结果
     * （3）对应的故障
     * @param id 任务id
     * @return: 
     * @auther: lvxianjin
     * @date: 2020/5/11 8:58
     */
    public void createSample(int id);
    /**
     *
     * 功能描述: 停止线程
     *
     * @param: id 任务id
     * @return:
     * @auther: lvxianjin
     * @date: 2020/5/11 13:48
     */
    public void stopSample(int id);
}
