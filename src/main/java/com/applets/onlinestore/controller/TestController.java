package com.applets.onlinestore.controller;

import com.applets.onlinestore.entity.User;
import com.applets.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WHLiang
 * @date 2019/11/5 10:30
 */
@RestController
public class TestController {

    @Autowired
    private UserService testService;

    @GetMapping("test")
    public String  test(){
        User test = testService.get();
        System.out.println(test);
        User testService1 = testService.get1();
        System.out.println(testService1);
        return "this is a test url";
    }
}
