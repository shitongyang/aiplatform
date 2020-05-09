package com.iscas.aiplatform.service.impl;

import com.iscas.aiplatform.mapper.UserMapper;
import com.iscas.aiplatform.mapper.WriteToDBMapper;
import com.iscas.aiplatform.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yangshitong
 * @Date 2020/5/9 12:43
 * @Version 1.0
 * @Description:
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private WriteToDBMapper writeToDBMapper;
    @Override
    public int writeToDB(String path, String describe, String username) {
        return writeToDBMapper.writeToOutputFormat(path,describe,username);
    }
}
