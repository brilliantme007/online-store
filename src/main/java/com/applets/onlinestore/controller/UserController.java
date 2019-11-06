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
public class UserController {

    @Autowired
    private UserService testService;

    @GetMapping("/home")
    public String  home(){
        return "这个页面登录了才能访问";
    }

    @GetMapping(value={"/","/index"})
    public String index(){
        return "这个页面任何人都能访问";
    }

    @GetMapping("/403")
    public String error403(){
        return "你娃虽然登录了,但是没权限!";
    }

    @GetMapping("/admin/index")
    public String admin(){
        return "admin权限";
    }

    @GetMapping("/user/index")
    public String user(){
        return "user权限";
    }

    @GetMapping("/login")
    public String login(){
        return "登录页面";
    }
}
