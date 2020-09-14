package com.iscas.aiplatform.service.impl;

import com.alibaba.fastjson.JSON;
import com.iscas.aiplatform.entity.Result;
import com.iscas.aiplatform.entity.TrainProcedure;
import com.iscas.aiplatform.mapper.TrainProcedureMapper;
import com.iscas.aiplatform.service.TrainProcedureService;
import com.iscas.aiplatform.utils.AddNoUtil;
import com.iscas.aiplatform.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * @Author yangshitong
 * @Date 2020/6/23 16:47
 * @Version 1.0
 * @Description:
 */

@Service
public class TrainProcedureServiceImpl implements TrainProcedureService {

    @Autowired
    private TrainProcedureMapper trainProcedureMapper;

    @Override
    public int upLoadProcedure(TrainProcedure trainProcedure) {
        trainProcedure.setCreateTime(TimeUtil.getCurrentTime());
        return trainProcedureMapper.insertTrainProcedure(trainProcedure);
    }


    @Override
    public String listProcedures(String username) {

        List resultList=trainProcedureMapper.listProcedures(username);
        Result result = new Result();
        result.setSuccess(true);
        result.setMsg("访问成功");
        result.setDetail(AddNoUtil.addNo(resultList));
        return JSON.toJSONString(result);
    }

    @Override
    public String deleteProcedure(int id) {
        Result result = new Result();
        if(trainProcedureMapper.deleteProcedure(id) == 1){
            result.setSuccess(true);
            result.setMsg("删除程序成功");
        }else {
            result.setSuccess(false);
            result.setMsg("删除程序失败");
        }
        return JSON.toJSONString(result);
    }

    @Override
    public List<Map<String, Object>> listProceduresName(String username) {
        return trainProcedureMapper.listProceduresName(username);
    }

    @Override
    public List<Map<String, Object>> listFaultsByDes(String formatDes, String username) {
        return trainProcedureMapper.listFaultsByDes(formatDes, username);
    }




}
