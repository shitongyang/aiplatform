package com.iscas.aiplatform.service;

/**
 * @Author yangshitong
 * @Date 2020/6/4 16:01
 * @Version 1.0
 * @Description:训练管理的服务接口
 */

public interface TrainService {
    /**
     * author: yangshitong
     * description: 上传用户执行目标训练程序的脚本
     * @params
     * @date 2020/6/4 16:04
     * @return
     */
    String upLoadScript();
    /**
     * author: yangshitong
     * description: 执行训练程序的启动
     * @params
     * @date 2020/6/4 16:08
     * @return
     */
    String executeTrainingProgram();
}
