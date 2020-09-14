package com.iscas.aiplatform.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author yangshitong
 * @Date 2020/5/19 18:55
 * @Version 1.0
 * @Description:
 */

@Setter
@Getter
public class OutPutFormat {

    private int id;

    private String username;

    private String path;

    private String describe;

    private String faultSet;

    public OutPutFormat(String username, String path, String describe, String faultSet) {
        this.username = username;
        this.path = path;
        this.describe = describe;
        this.faultSet = faultSet;
    }


}
