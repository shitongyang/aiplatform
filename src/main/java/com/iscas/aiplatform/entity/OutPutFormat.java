package com.iscas.aiplatform.entity;

/**
 * @Author yangshitong
 * @Date 2020/5/19 18:55
 * @Version 1.0
 * @Description:
 */

public class OutPutFormat {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public OutPutFormat(String username, String path, String describe, String faultSet) {
        this.username = username;
        this.path = path;
        this.describe = describe;
        this.faultSet = faultSet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getFaultSet() {
        return faultSet;
    }

    public void setFaultSet(String faultSet) {
        this.faultSet = faultSet;
    }

    private String username;

    private String path;

    private String describe;

    private String faultSet;

}
