package com.iscas.aiplatform.mapper;

import com.iscas.aiplatform.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author yangshitong
 * @Date 2020/5/7 14:44
 * @Version 1.0
 * @Description:
 */
@Mapper
@Component
public interface UserMapper {

    String login(String username,String password);
    int regist(User user);
    User findUserByName(String username);
}
