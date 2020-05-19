package com.iscas.aiplatform.service;

import java.util.List;
import java.util.Map;

/**
 * @Author yangshitong
 * @Date 2020/5/12 13:43
 * @Version 1.0
 * @Description:
 */

public interface ModelFileService {

    int addModelFile(String modelName,String modelDes,String modelFormat,String username,String modelStorePath);

    String shareModelFile(int id);
    //分享模型文件

    String cancelShareModelFile(int id);
    //取消分享模型文件

    String showModelFileByName(String username);
    //根据名字检索展示模型文件

    String showSharedModelFile();
    //展示共享出来的模型文件
}
