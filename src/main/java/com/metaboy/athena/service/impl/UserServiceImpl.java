package com.metaboy.athena.service.impl;

import com.metaboy.athena.dao.UserMapper;
import com.metaboy.athena.model.User;
import com.metaboy.athena.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by metaboy on 16/4/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Long addUser(User user) {
        return userMapper.addUserModel(user);
    }

    @Override
    public Long addUser2Project(User user, Long projectId, Integer role) {
        return 1L;
    }


}
