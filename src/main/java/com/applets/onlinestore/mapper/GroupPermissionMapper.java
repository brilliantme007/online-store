package com.applets.onlinestore.mapper;

import com.applets.onlinestore.entity.GroupPermission;
import com.applets.onlinestore.entity.Permission;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author WHLiang
 * @date 2019/11/5 10:38
 */
@Repository
public interface GroupPermissionMapper {
    @Select("select * from t_group_permission where rgroupid= #{id}")
    @Results({@Result(property = "permission",column = "rpermissionid",one = @One(select = "com.applets.onlinestore.mapper.PermissionMapper.findByFid"))})
    GroupPermission findByGroupId(String id);

    @Select("select * from t_group_permission where rpermissionid= #{id}")
    List<GroupPermission> findByPermissionId(String id);
}
