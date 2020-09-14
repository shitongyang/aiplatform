package com.iscas.aiplatform.service;

import com.iscas.aiplatform.entity.TrainInstance;

import java.util.List;
import java.util.Map;

/**
 * @Author yangShiTong
 * @Date 2020/9/14 11:32
 * @Version 1.0
 * @Description: 训练实例的服务
 */

public interface TrainInstanceService {


    /**
     * author: YangShiTong
     * description: 创建一个训练实例
     * @param   trainInstance 对象实例
     * @date 2020/7/8 11:07
     * @return
     */
    String insertTrainInstance(TrainInstance trainInstance);

    /**
     * author: YangShiTong
     * description: 根据用户名获取实例列表
     * @param username
     * @date 2020/7/8 11:45
     * @return
     */
    List<Map<String,Object>> listInstances(String username);

    /**
     * author: yangshitong
     * description: 启动训练实例
     * @param
     * @date 2020/6/4 16:08
     * @return
     */
    String startTrainInstance();


    /**
     * author: YangShiTong
     * description: 终止一个实例的运行
     * @param
     * @date 2020/9/14 14:52
     * @return
     */
    String terminateTrainInstance();
}
