package com.applets.onlinestore.mapper;

import com.applets.onlinestore.entity.GroupPermission;
import com.applets.onlinestore.entity.GroupUser;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author WHLiang
 * @date 2019/11/5 10:38
 */
@Repository
public interface GroupUserMapper {
    @Select("select * from t_group_user where ruserid= #{userId}")
    @Results({@Result(property = "group",column = "rgroupid",one = @One(select = "com.applets.onlinestore.mapper.GroupMapper.findByFid"))})
    GroupUser findByUserId(String userId);
}
