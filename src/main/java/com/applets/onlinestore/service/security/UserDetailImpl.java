package com.applets.onlinestore.service.security;

import com.applets.onlinestore.entity.Group;
import com.applets.onlinestore.entity.GroupPermission;
import com.applets.onlinestore.entity.GroupUser;
import com.applets.onlinestore.entity.Permission;
import com.applets.onlinestore.entity.User;
import com.applets.onlinestore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author WHLiang
 * @date 2019/11/6 15:44
 */
public class UserDetailImpl implements UserDetails {

    private String username;
    private String password;
    //@WHLiang 待定......
    private User user;

    @Autowired
    private UserService userService;

    public UserDetailImpl() {
    }

    public UserDetailImpl(User user) {
        this.user = user;
        this.username = user.getFloginname();
        this.password = user.getFpassword();
    }

    /**
     * 返回该用户所有权限
     * @WHLiang 待定
     *
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<GroupUser> groupUserList = user.getGroupUser();
        if (groupUserList != null && !groupUserList.isEmpty()) {
            for (GroupUser groupUser : groupUserList) {
                Group group = groupUser.getGroup();
                if (group != null ) {
                    List<GroupPermission> groupPermissions = group.getGroupPermissions();
                    if (groupPermissions != null && !groupPermissions.isEmpty()){
                        for (GroupPermission groupPermission : groupPermissions) {
                            Permission permission = groupPermission.getPermission();
                            if(permission!= null){
                                authorities.add(new SimpleGrantedAuthority(permission.getFurl()));
                            }
                        }
                    }
                }
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * 判断账号是否已经过期 默认没有过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 判断账号是否被锁定  默认没有锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 判断信用凭证是否过期,磨人没有过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 判断战壕是否可用,默认可用
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
