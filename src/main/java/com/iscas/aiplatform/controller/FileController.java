package com.iscas.aiplatform.controller;

import com.iscas.aiplatform.service.FileService;
import com.iscas.aiplatform.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author yangshitong
 * @Date 2020/5/8 15:33
 * @Version 1.0
 * @Description:上传文件
 */

@Controller
@CrossOrigin("*")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value="/gouploadimg", method = RequestMethod.GET)
    public String goUploadImg() {
        //跳转到 templates 目录下的 uploadimg.html
        return "uploadimg";
    }

    @RequestMapping(value="/testuploadimg", method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file,
                     HttpServletRequest request,@RequestParam(value = "describe",defaultValue = "特高压") String describe,@RequestParam(value = "username",defaultValue = "张三")String username) {
        String fileName = file.getOriginalFilename();
        String filePath = "/format/"+username;

        System.out.println("1111"+filePath+"11111");

        filePath=filePath+"/"+FileUtil.getFolderCount(filePath)+"/";

        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        //返回json
        fileService.writeToDB(filePath,describe,username);
        return "uploadimg success";
    }
}
