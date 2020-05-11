package com.iscas.aiplatform.utils;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @Author yangshitong
 * @Date 2020/5/8 15:35
 * @Version 1.0
 * @Description:文件上传工具类
 */

public class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    public static int getFolderCount(String path){
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("存放输出格式的文件夹为空");
            file.mkdirs();
        }
        File[] files = file.listFiles();
        int count=0;
        for (File f:files
             ) {
            if(f.isDirectory()){
                count++;
            }
        }
        //返回的文件夹数目加1，新建文件夹
        return count+1;
    }
}
