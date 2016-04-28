package com.metaboy.athena.dao;

import com.metaboy.athena.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by metaboy on 16/4/27.
 */
@Repository
public interface UserMapper {

    Long addUserModel(User user);
}
