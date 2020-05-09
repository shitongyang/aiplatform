package com.iscas.aiplatform.service;

/**
 * @Author yangshitong
 * @Date 2020/5/9 12:39
 * @Version 1.0
 * @Description:负责将上传文件的路径以及用户的描述写入数据库
 */

public interface FileService {

    int writeToDB(String path,String describe,String username);
}
