package com.iscas.aiplatform.service;

import com.iscas.aiplatform.entity.TrainInstance;
import com.iscas.aiplatform.entity.TrainProcedure;

import java.util.List;
import java.util.Map;

/**
 * @Author yangshitong
 * @Date 2020/6/4 16:01
 * @Version 1.0
 * @Description:训练管理的服务接口
 */

public interface TrainService {
    /**
     * author: yangshitong
     * description: 上传用户执行目标训练程序和脚本
     * @param trainProcedure 实体类
     * @date 2020/6/4 16:04
     * @return
     */
    int upLoadProcedure(TrainProcedure trainProcedure);

    /**
     * author: yangshitong
     * description: 执行训练程序的启动
     * @param
     * @date 2020/6/4 16:08
     * @return
     */
    String executeTrainingProgram();

    /**
     * author: YangShiTong
     * description:
     * @param username 用户名
     * @date 2020/7/1 13:45
     * @return
     */
    String listProcedures(String username);

    /**
     * author: YangShiTong
     * description:
     * @param id  训练程序的id
     * @date 2020/7/1 15:24
     * @return
     */
    String deleteProcedure(int id);

    /**
     * author: YangShiTong
     * description: 获取用户上传的程序名字
     * @param username 用户名
     * @date 2020/7/2 15:38
     * @return
     */
    List<Map<String,Object>> listProceduresName(String username);

    /**
     * author: YangShiTong
     * description: 根据描述获取故障集
     * @param formatDes 描述
     * @date 2020/7/3 9:41
     * @return
     */
    List<Map<String,Object>> listFaultsByDes(String formatDes,String username);

    /**
     * author: YangShiTong
     * description:
     * @param   trainInstance 对象实例
     * @date 2020/7/8 11:07
     * @return
     */
    String insertTrainInstance(TrainInstance trainInstance);


    /**
     * author: YangShiTong
     * description: 根据用户名获取实例
     * @param
     * @date 2020/7/8 11:45
     * @return
     */
    List<Map<String,Object>> listInstances(String username);
}
