package com.iscas.aiplatform.controller;

import com.alibaba.fastjson.JSON;
import com.iscas.aiplatform.entity.Result;
import com.iscas.aiplatform.service.ModelFileService;
import com.iscas.aiplatform.service.OutputFormatService;
import com.iscas.aiplatform.utils.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author yangshitong
 * @Date 2020/5/8 15:33
 * @Version 1.0
 * @Description:上传文件包含两个：一个样本输出格式文件，一个模型文件
 */

@RestController
@CrossOrigin("*")
public class FileController {

   Logger logger =LoggerFactory.getLogger(getClass());
    @Autowired
    private OutputFormatService outputFormatService;

    @Autowired
    private ModelFileService modelFileService;

    @RequestMapping(value="/gouploadimg", method = RequestMethod.GET)
    public String goUploadImg() {
        // 跳转到 templates 目录下的 uploadimg.html
        return "uploadimg";
    }

    @RequestMapping(value="/testuploadimg", method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file,
                                          HttpServletRequest request,@RequestParam(value = "describe") String describe, @RequestParam(value = "username")String username,@RequestParam(value="faultSet")String faultSet,@RequestParam(value="start")String start) {
        logger.info(file.getOriginalFilename()+"/"+describe+"/"+username+"/"+faultSet+"/"+start);
        String fileName = file.getOriginalFilename();
        String filePath = "/format/"+username;

        filePath=filePath+"/"+FileUtil.getFolderCount(filePath)+"/";

        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
            logger.info("上传样本输出格式文件失败"+e.getMessage());
            Result result=new Result("上传样本输出格式文件失败",false);
            return JSON.toJSONString(result);
        }
        // 返回json
        return outputFormatService.addOutputFormat(filePath+"/"+fileName,describe,username,faultSet,start);
        // fileService.writeToDB(filePath,describe,username);

    }

    @RequestMapping(value="/uploadModelFile", method = RequestMethod.POST)
    public @ResponseBody String uploadModelFile(@RequestParam("file") MultipartFile file,@RequestParam(value = "modelName",defaultValue = "默认值") String modelName,
                                  @RequestParam(value = "modelDes",defaultValue = "默认值")String modelDes,@RequestParam(value = "modelFormat",defaultValue = "默认值")String modelFormat,@RequestParam(value = "username",defaultValue = "默认值")String username){
        String fileName = file.getOriginalFilename();
        String filePath = "/model_file/"+username;

        filePath=filePath+"/"+FileUtil.getFolderCount(filePath)+"/";

        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
            logger.info("上传模型文件失败"+e.getMessage());
            Result result=new Result("上传模型文件失败",false);
            return JSON.toJSONString(result);
        }
        modelFileService.addModelFile(modelName, modelDes, modelFormat, username, filePath);
        return JSON.toJSONString(new Result("上传模型文件成功", true));
    }
}
