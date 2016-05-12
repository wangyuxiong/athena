package com.metaboy.athena.service.impl;

import com.metaboy.athena.dao.UserMapper;
import com.metaboy.athena.model.User;
import com.metaboy.athena.service.UserService;
import com.metaboy.athena.utils.DecryptionUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by metaboy on 16/4/27.
 */
@Service
public class UserServiceImpl implements UserService {

    private static Log logger = LogFactory.getLog(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public Long addUser(User user) {
        user.setPasswd(DecryptionUtil.encrypt(user.getPasswd()));
        int ret = userMapper.addUserModel(user);
        if (ret > 0) {
            return user.getId();
        } else {
            return -1L;
        }
    }

    @Override
    public Integer removeUser(Long userId) {
        return userMapper.removeUserModel(userId);
    }

    @Override
    public Integer deleteUser(Long userId) {
        return userMapper.deleteUser(userId);
    }

    @Override
    public Integer modifyUserInfo(User user) {
        return userMapper.modifyUserInfo(user);
    }

    @Override
    public User getUserByUser(String userName) {
        User user = new User();
        user.setUserName(userName);
        return userMapper.getUser(user);
    }


    @Override
    public User getUserByEmail(String email) {
        User user = new User();
        user.setEmail(email);
        return userMapper.getUser(user);
    }

    //todo project 相关接口
    @Override
    public Long addUser2Project(User user, Long projectId, Integer role) {
        return 1L;
    }


    @Override
    public Integer removeUserInProject(Long userId, Long projectId) {
        return 1;
    }

    @Override
    public Integer modifyUserRoleInProject(Long userId, Long projectId, Integer newRole) {
        return 1;
    }
}
