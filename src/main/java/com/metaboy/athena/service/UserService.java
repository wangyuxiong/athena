package com.metaboy.athena.service;

import com.metaboy.athena.model.User;

/**
 * Created by metaboy on 16/4/27.
 */
public interface UserService {

    /*
    用户注册
     */
    Long addUser(User user);

    /*
    添加用户到project中
     */
    Long addUser2Project(User user, Long projectId, Integer role);


}
