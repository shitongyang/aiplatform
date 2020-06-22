package com.iscas.aiplatform.service;

/**
 * @Author yangshitong
 * @Date 2020/5/12 13:43
 * @Version 1.0
 * @Description:
 */

public interface ModelFileService {

    int addModelFile(String modelName,String modelDes,String modelFormat,String username,String modelStorePath);

    /**
     * author: yangshitong
     * description: 通过模型文件的id进行分享
     * @params int id
     * @date 2020/6/4 9:54
     * @return
     */
    String shareModelFile(int id);

    String cancelShareModelFile(int id);
    // 取消分享模型文件

    String showModelFileByName(String username);
    // 根据名字检索展示模型文件

    String showSharedModelFile();
    // 展示共享出来的模型文件

    String getModelFormat();
    // 获取模型格式列表

    /**
     * author: YangShiTong
     * description: 删除某一模型文件 逻辑删除
     * @params
     * @date 2020/6/18 15:30
     * @return
     */
    String deleteModelFile(int id);

}
