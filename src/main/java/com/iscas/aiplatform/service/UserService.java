package com.iscas.aiplatform.service;

import com.iscas.aiplatform.entity.User;


/**
 * @Author yangshitong
 * @Date 2020/5/7 12:46
 * @Version 1.0
 * @Description:
 */

public interface UserService {

    String userLogin(String username, String password);

    String userRegist(User user);



}
