package com.iscas.aiplatform.mapper;

import com.iscas.aiplatform.entity.TrainInstance;
import com.iscas.aiplatform.entity.TrainProcedure;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author yangshitong
 * @Date 2020/6/30 19:10
 * @Version 1.0
 * @Description: 对训练程序的操作
 */

@Mapper
@Component
public interface TrainProcedureMapper {

    /**
     * author: YangShiTong
     * description: 保存训练程序到数据库
     * @param trainProcedure 实体类
     * @date 2020/6/30 19:17
     * @return
     */
    int insertTrainProcedure(TrainProcedure trainProcedure);

    /**
     * author: YangShiTong
     * description: 根据用户名查询出训练程序
     * @param username 用户名
     * @date 2020/7/1 13:54
     * @return
     */
    List<Map<String, Object>> listProcedures(String username);

    int deleteProcedure(int id);

    List<Map<String, Object>> listProceduresName(String username);

    List<Map<String, Object>> listFaultsByDes(String formatDes, String username);


}
