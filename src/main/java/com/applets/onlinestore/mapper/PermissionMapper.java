package com.applets.onlinestore.mapper;

import com.applets.onlinestore.entity.Permission;
import com.applets.onlinestore.entity.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author WHLiang
 * @date 2019/11/5 10:38
 */
@Repository
public interface PermissionMapper {
    @Select("select * from t_permission where fid= #{id}")
    Permission findByFid(String id);
    @Select("select * from t_permission where furl = #{url}")
    Permission findByUrl(String url);
}
