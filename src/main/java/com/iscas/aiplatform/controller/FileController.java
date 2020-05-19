package com.iscas.aiplatform.controller;

import com.alibaba.fastjson.JSON;
import com.iscas.aiplatform.entity.Result;
import com.iscas.aiplatform.service.ModelFileService;
import com.iscas.aiplatform.service.OutputFormatService;
import com.iscas.aiplatform.utils.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        //跳转到 templates 目录下的 uploadimg.html
        return "uploadimg";
    }

    @RequestMapping(value="/testuploadimg", method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file,
                     HttpServletRequest request,@RequestParam(value = "describe") String describe,
                                          @RequestParam(value = "username")String username,@RequestParam(value="faultSet")String faultSet,@RequestParam(value="start")String start) {
        logger.info(file.getOriginalFilename()+"/"+describe+"/"+username+"/"+faultSet+"/"+start);
        String fileName = file.getOriginalFilename();
        String filePath = "/format/"+username;

        filePath=filePath+"/"+FileUtil.getFolderCount(filePath)+"/";

        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
            logger.info("上传失败"+e.getMessage());
            Result result=new Result("上传失败",false);
            return JSON.toJSONString(result);
        }
        //返回json
        return outputFormatService.addOutputFormat(filePath+"/"+fileName,describe,username,faultSet,start);
        //fileService.writeToDB(filePath,describe,username);

    }

    @RequestMapping(value="/uploadModelFile", method = RequestMethod.POST)
    public @ResponseBody String uploadModelFile(@RequestParam("file") MultipartFile file, HttpServletRequest request,@RequestParam(value = "modelName",defaultValue = "模型A") String modelName,
                                  @RequestParam(value = "modelDes",defaultValue = "用来预测电压的大小")String modelDes,@RequestParam(value = "modelFormat",defaultValue = "h5")String modelFormat,@RequestParam(value = "username",defaultValue = "李四")String username){
        String fileName = file.getOriginalFilename();
        String filePath = "/model_file/"+username;

        System.out.println("1111"+filePath+"11111");

        filePath=filePath+"/"+FileUtil.getFolderCount(filePath)+"/";

        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        modelFileService.addModelFile(modelName,modelDes,modelFormat,username,filePath);
        return "upload model_file success!";
    }
}
