package com.applets.onlinestore.mapper;

import com.applets.onlinestore.entity.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author WHLiang
 * @date 2019/11/5 10:38
 */
@Repository
public interface UserMapper {

    User sel(String fid);

    @Select("select * from t_user where fid = #{fid}")
    User sel1(String fid);

    @Select("select * from t_user where floginname= #{loginName}")
    @Results({
            @Result(property = "groupUser",  column = "fid",many = @Many(select = "com.applets.onlinestore.mapper.GroupUserMapper.findByUserId"))
    })
    User findByLoginName(String loginName);
}
