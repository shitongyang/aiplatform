package com.iscas.aiplatform.controller;

import com.alibaba.fastjson.JSONObject;
import com.iscas.aiplatform.entity.Result;
import com.iscas.aiplatform.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yangshitong
 * @Date 2020/5/7 9:42
 * @Version 1.0
 * @Description:用户的登录和注册
 */

@RestController
@CrossOrigin("*")

@Api(value = "用户Controller", tags = { "用户登录和注册接口" })
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录")
    @PostMapping(value="/login")
    public String login(@RequestBody String message){
        JSONObject object;
        try {
            object = JSONObject.parseObject(message);
        }catch (Exception e){
            System.out.println("前端传过来的参数不符合json格式");
            return Result.jsonErrorResult(message);
        }
        return userService.userLogin(object.getString("username"),object.getString("password"));
    }
    @ApiOperation(value = "用户注册")
    @RequestMapping(value="/regist",method = RequestMethod.POST)
    public String regist(@RequestBody String userString){
        JSONObject object;
        try {
            object = JSONObject.parseObject(userString);
        }catch (Exception e){
            System.out.println("前端传过来的参数不符合json格式");
            return Result.jsonErrorResult(userString);
        }
        return userService.userRegister(userString);
    }
}
