package com.iscas.aiplatform.mapper;

import com.iscas.aiplatform.entity.OutPutFormat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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
    int writeToOutputFormat(OutPutFormat outPutFormat);

    //将样本数据进行分享操作
    int shareSampleStatus(int id);

    //取消分享
    int cancelShareSampleStatus(int id);

    List<Map<String,Object>> showSampleByName(String userName);

    List<Map<String,Object>> showSharedSample();

    List<Map<String,Object>> selectFaultSet();

}
