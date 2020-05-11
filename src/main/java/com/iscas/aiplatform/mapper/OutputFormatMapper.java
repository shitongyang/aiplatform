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
public interface OutputFormatMapper {

    //将用户上传的样本数据输出格式保存到服务器，然后将路径和其他信息写入到output_format表
    int writeToOutputFormat(String path,String describe,String username);

    //将样本数据进行分享操作
    int shareSampleStatus(int id);

    //取消分享
    int cancelShareSampleStatus(int id);

}
