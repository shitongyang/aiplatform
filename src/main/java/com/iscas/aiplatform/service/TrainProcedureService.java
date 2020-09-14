package com.iscas.aiplatform.service;

import com.iscas.aiplatform.entity.TrainProcedure;
import java.util.List;
import java.util.Map;

/**
 * @Author yangshitong
 * @Date 2020/6/4 16:01
 * @Version 1.0
 * @Description:训练程序的服务接口
 */

public interface TrainProcedureService {
    /**
     * author: yangshitong
     * description: 上传用户执行目标训练程序和脚本
     * @param trainProcedure 实体类
     * @date 2020/6/4 16:04
     * @return
     */
    int upLoadProcedure(TrainProcedure trainProcedure);



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
     * description: 删除训练程序
     * @param id  训练程序的id
     * @date 2020/7/1 15:24
     * @return
     */
    String deleteProcedure(int id);

    /**
     * author: YangShiTong
     * description: 获取用户上传的程序名字(用于创建训练实例)
     * @param username 用户名
     * @date 2020/7/2 15:38
     * @return
     */
    List<Map<String,Object>> listProceduresName(String username);

    /**
     * author: YangShiTong
     * description: 根据描述获取故障集
     * @param formatDes 描述
     * @param username 用户名
     * @date 2020/7/3 9:41
     * @return
     */
    List<Map<String,Object>> listFaultsByDes(String formatDes,String username);





}
