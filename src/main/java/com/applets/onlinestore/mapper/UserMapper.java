package com.applets.onlinestore.mapper;

import com.applets.onlinestore.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author WHLiang
 * @date 2019/11/5 10:38
 */
@Repository
public interface UserMapper {

    User sel(String fid);

    @Select("select * from t_test where fid = '111'")
    User sel1(String fid);
}
