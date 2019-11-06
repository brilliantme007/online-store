package com.applets.onlinestore.utils;

import com.applets.onlinestore.entity.Group;
import com.applets.onlinestore.entity.GroupPermission;
import com.applets.onlinestore.entity.GroupUser;
import com.applets.onlinestore.entity.Permission;
import com.applets.onlinestore.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WHLiang
 * @date 2019/11/6 16:07
 */
public class UserUtil {
    /**
     * 获取用户的所有权限
     * @param user
     * @return
     */
    public static final List<Permission> getAllPermissionOfUser(User user){
        List<Permission> result = new ArrayList<>();
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
                                result.add(permission);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
