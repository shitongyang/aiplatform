package com.iscas.aiplatform.entity;

import lombok.Data;

/**
 * @Author yangshitong
 * @Date 2020/7/8 10:52
 * @Version 1.0
 * @Description:
 */

@Data
public class TrainInstance {
    private  int  id;
    private String instanceName;
    private String status;
    private int trainProcedureId;
    private String outputFormatDes;
    private String faultSets;
    private String sampleStartTime;
    private String sampleEndTime;
    private String trainOutputPath;
    private int isDistributed;
    private int computeNodes;
    private String instanceDes;
    private int runTime;
    private String createTime;
    private String username;

    public TrainInstance(String instanceName, String status, int trainProcedureId, String outputFormatDes, String faultSets, String sampleStartTime, String sampleEndTime, String trainOutputPath, int isDistributed, int computeNodes, String instanceDes, int runTime, String createTime, String username) {
        this.instanceName = instanceName;
        this.status = status;
        this.trainProcedureId = trainProcedureId;
        this.outputFormatDes = outputFormatDes;
        this.faultSets = faultSets;
        this.sampleStartTime = sampleStartTime;
        this.sampleEndTime = sampleEndTime;
        this.trainOutputPath = trainOutputPath;
        this.isDistributed = isDistributed;
        this.computeNodes = computeNodes;
        this.instanceDes = instanceDes;
        this.runTime = runTime;
        this.createTime = createTime;
        this.username = username;
    }
}
