package com.iscas.aiplatform.entity;

/**
 * 用户信息
 */
public class User {
    private Long id;
    private String username;
    //用户名
    private String password;
    //密码
    private String researchGroup;
    //课题组
    private String organization;
    //组织、所属单位


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getResearchGroup() {
        return researchGroup;
    }

    public void setResearchGroup(String researchGroup) {
        this.researchGroup = researchGroup;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
