package com.applets.onlinestore.service.security;

import com.applets.onlinestore.entity.Permission;
import com.applets.onlinestore.entity.User;
import com.applets.onlinestore.mapper.UserMapper;
import com.applets.onlinestore.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author WHLiang
 * @date 2019/11/6 15:42
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public List<Permission> getAllPermission(String loginName){
        return UserUtil.getAllPermissionOfUser(userMapper.findByLoginName(loginName));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("用户:"+s);
        User user = userMapper.findByLoginName(s);
        if(user == null){
            throw new UsernameNotFoundException("没有该用户");
        }
        return new UserDetailImpl(user);
    }
}
