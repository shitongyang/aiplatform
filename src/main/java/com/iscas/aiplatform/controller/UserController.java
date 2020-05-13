package com.iscas.aiplatform.controller;

import com.iscas.aiplatform.entity.User;
import com.iscas.aiplatform.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author yangshitong
 * @Date 2020/5/7 9:42
 * @Version 1.0
 * @Description:
 */

@RestController
@CrossOrigin("*")

@Api(value = "用户Controller", tags = { "用户登录和注册接口" })
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录")
    @PostMapping(value="/login")
    public String login(@ApiParam("用户名") @RequestParam("username") String username, @ApiParam("密码") @RequestParam("password")String password){
        return userService.userLogin(username,password);
    }
    @ApiOperation(value = "用户注册")
    @RequestMapping(value="/regist",method = RequestMethod.POST)
    public String regist(User user){
        return userService.userRegist(user);
    }
}
