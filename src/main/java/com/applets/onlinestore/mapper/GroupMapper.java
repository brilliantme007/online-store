package com.applets.onlinestore.mapper;

import com.applets.onlinestore.entity.Group;
import com.applets.onlinestore.entity.User;
import org.apache.ibatis.annotations.Many;
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
public interface GroupMapper {
    @Select("select * from t_group where fid= #{fid}")
    @Results({
            @Result(property = "groupPermissions",  column = "fid",many = @Many(select = "com.applets.onlinestore.mapper.GroupPermissionMapper.findByGroupId"))
    })
    Group findByFid(String fid);

    @Select("select * from t_group where fid in #{groupIds}")
    List<Group> findByFidIn(List<String> gorupIds);
}
