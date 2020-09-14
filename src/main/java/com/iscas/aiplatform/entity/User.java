package com.iscas.aiplatform.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author yangshitong
 * 用户信息
 */

@Setter
@Getter
public class User {

    private Long id;
    private String username;
    private String password;

    /*
    *课题组
    */

    private String researchGroup;


    /*
     *组织、所属单位
     */

    private String organization;

}
