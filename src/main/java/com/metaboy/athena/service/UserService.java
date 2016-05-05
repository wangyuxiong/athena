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
     * 添加用户到project中
     *
     * @param user
     * @param projectId
     * @param role
     * @return
     */
    Long addUser2Project(User user, Long projectId, Integer role);


    /**
     * @param userId
     * @param projectId
     * @return
     */
    Integer removeUserInProject(Long userId, Long projectId);

    /**
     * @param userId
     * @param projectId
     * @param newRole
     * @return
     */
    Integer modifyUserRoleInProject(Long userId, Long projectId, Integer newRole);

}
