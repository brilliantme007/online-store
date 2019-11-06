package com.applets.onlinestore.service;

import com.applets.onlinestore.entity.User;
import com.applets.onlinestore.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WHLiang
 * @date 2019/11/5 10:36
 */
@Service
public class UserService {

    @Autowired
    private UserMapper testMapper;


    public User findByLoginName(String loginName){
        return testMapper.findByLoginName(loginName);
    }
}
