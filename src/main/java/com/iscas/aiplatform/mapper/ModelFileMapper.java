package com.iscas.aiplatform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author yangshitong
 * @Date 2020/5/12 9:13
 * @Version 1.0
 * @Description:对模型文件的操作model_file
 */
@Mapper
@Component
public interface ModelFileMapper {

    int insertModelFile(String modelName,String modelDes,String modelFormat,String username,String modelStorePath);
    //插入一条模型文件记录

    int shareModelFile(int id);
    //分享模型文件

    int cancelShareModelFile(int id);
    //取消分享模型文件

    List<Map<String,Object>> selectModelFileByName(String username);
}
