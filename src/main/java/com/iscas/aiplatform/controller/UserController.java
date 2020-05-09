package com.iscas.aiplatform.controller;

import com.iscas.aiplatform.entity.User;
import com.iscas.aiplatform.service.UserService;
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
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password")String password){
        return userService.userLogin(username,password);
    }
    @RequestMapping(value="/regist",method = RequestMethod.POST)
    public String regist(User user){
        return userService.userRegist(user);
    }
}
