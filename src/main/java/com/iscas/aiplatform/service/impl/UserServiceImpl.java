package com.iscas.aiplatform.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.iscas.aiplatform.entity.Result;
import com.iscas.aiplatform.entity.User;
import com.iscas.aiplatform.mapper.UserMapper;
import com.iscas.aiplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yangshitong
 * @Date 2020/5/7 14:35
 * @Version 1.0
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String userLogin(String username, String password) {
        String loginResult = userMapper.login(username, password);
        Result result = new Result();
        result.setSuccess(false);
        if (loginResult == null) {
            result.setMsg("用户名或密码错误");
            result.setDetail(null);
        } else {
            result.setSuccess(true);
            result.setMsg("登录成功");
            JSONObject o=new JSONObject();
            o.put("username",username);
            result.setDetail(o);
        }

        return JSON.toJSONString(result);
    }
    @Override
    public String userRegister(String userString) {

        Result result=new Result();
        User user = JSON.parseObject(userString, User.class);
        User user1=userMapper.findUserByName(user.getUsername());
        if(user1==null) {
            int i = userMapper.regist(user);
            result.setMsg("注册成功");
            result.setSuccess(true);
            result.setDetail(user);
        }
        else {
            result.setMsg("用户名已存在");
            result.setSuccess(false);
        }
        return JSON.toJSONString(result);
    }

}
