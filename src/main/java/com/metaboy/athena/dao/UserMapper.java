package com.metaboy.athena.dao;

import com.metaboy.athena.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by metaboy on 16/4/27.
 */
@Repository
public interface UserMapper {

    Long addUserModel(User user);

    Integer removeUserModel(Long userId);

    Integer modifyUserInfo(User user);

    User getUser(@Param("user") User user);
}
