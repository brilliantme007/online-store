package com.applets.onlinestore.service.security;

import com.applets.onlinestore.entity.Group;
import com.applets.onlinestore.entity.GroupPermission;
import com.applets.onlinestore.entity.Permission;
import com.applets.onlinestore.mapper.GroupMapper;
import com.applets.onlinestore.mapper.GroupPermissionMapper;
import com.applets.onlinestore.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author WHLiang
 * @date 2019/11/6 16:51
 */
// 接收用户请求的地址,返回访问改地址需要的所有权限
public class FilterInvocationSecurityMetadataSourceImpl implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private GroupPermissionMapper groupPermissionMapper;
    @Autowired
    private GroupMapper groupMapper;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

        String requestUrl = ((FilterInvocation)o).getRequestUrl();
        System.out.println("用户请求的地址是:"+requestUrl);
        // 登录页面就不需要权限
        if("/login".equals(requestUrl)){
            return null;
        }
        // 不是权限表里面有的链接,说明都可以访问
        Permission byUrl = permissionMapper.findByUrl(requestUrl);
        if (byUrl == null){
            return SecurityConfig.createList("ROLE_LOGIN");
        }
        String fid = byUrl.getFid();
        List<GroupPermission> byPermissionId = groupPermissionMapper.findByPermissionId(fid);
        List<String> groupIds = new ArrayList<>();
        if(byPermissionId!=null && !byPermissionId.isEmpty()){
            for (GroupPermission groupPermission : byPermissionId) {
                groupIds.add(groupPermission.getRgroupid());
            }
        }

        List<Group> byFidIn = new ArrayList<>();
        if (!groupIds.isEmpty()){
            byFidIn = groupMapper.findByFidIn(groupIds);
        }
        int size = byFidIn.size();
        String[] values = new String[byFidIn.size()];
        for (int i = 0; i < size; i++) {
            values[i] = byFidIn.get(i).getFgroupname();
        }
        return SecurityConfig.createList(values);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
