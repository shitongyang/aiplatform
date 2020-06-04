package com.iscas.aiplatform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author : lvxianjin
 * @Date: 2020/5/11 09:37
 * @Description:
 */
@Mapper
@Component
public interface SampleMapper {
     Map<String,String> getSampleInfo(int id);
     int addSample(String sample_path,int id);
}
