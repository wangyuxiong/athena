package com.metaboy.athena.service;

import com.metaboy.athena.model.User;

/**
 * Created by metaboy on 16/4/27.
 */
public interface UserService {

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    Long addUser(User user);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    Integer modifyUserInfo(User user);

    /**
     * 移除用户
     *
     * @param userId
     * @return
     */
    Integer removeUser(Long userId);

    /**
     * 删除用户的所有信息
     * @param userId
     * @return
     */
    Integer deleteUser(Long userId);

    /**
     * 通过用户名获取用户
     *
     * @param userName
     * @return
     */
    User getUserByUser(String userName);


    /**
     * 通过 email 获取用户
     *
     * @param email
     * @return
     */
    User getUserByEmail(String email);



}
