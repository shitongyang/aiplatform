package com.iscas.aiplatform.mapper;

import com.iscas.aiplatform.entity.TrainInstance;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author yangShiTong
 * @Date 2020/9/14 11:42
 * @Version 1.0
 * @Description:
 */
@Mapper
@Component
public interface TrainInstanceMapper {


    /**
     * author: YangShiTong
     * description: 创建一个训练实例，保存到数据库
     * @param trainInstance
     * @date 2020/9/14 14:20
     * @return
     */
    int insertTrainInstance(TrainInstance trainInstance);



    /**
     * author: YangShiTong
     * description: 根据用户名获取训练实例列表
     * @param username
     * @date 2020/9/14 14:20
     * @return
     */
    List<Map<String, Object>> listInstances(String username);
}
