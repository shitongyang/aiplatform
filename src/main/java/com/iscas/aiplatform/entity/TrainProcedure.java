package com.iscas.aiplatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author yangshitong
 * @Date 2020/6/30 19:37
 * @Version 1.0
 * @Description: 训练程序实体类
 */
@Data
public class TrainProcedure {

    private int id;
    private  String procedureName;
    private String procedureDes;
    private String procedurePath;
    private String scriptPath;
    private String notes;
    private String username;
    private String createTime;

    public TrainProcedure(String procedureName, String procedureDes, String procedurePath, String scriptPath, String notes, String username) {
        this.procedureName = procedureName;
        this.procedureDes = procedureDes;
        this.procedurePath = procedurePath;
        this.scriptPath = scriptPath;
        this.notes = notes;
        this.username = username;
    }
}
