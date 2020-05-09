package com.iscas.aiplatform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author yangshitong
 * @Date 2020/5/9 12:46
 * @Version 1.0
 * @Description:
 */

@Mapper
@Component
public interface WriteToDBMapper {

    int writeToOutputFormat(String path,String describe,String username);
    //写入到output_format表

}
