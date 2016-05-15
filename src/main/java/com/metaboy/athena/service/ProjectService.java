package com.metaboy.athena.service;

import com.metaboy.athena.model.Page;
import com.metaboy.athena.model.Project;

import java.util.List;

/**
 * Created by metaboy on 16/5/15.
 */
public interface ProjectService {

    Long addProject(Project project);

    Project getProjectById(Long projectId);

    Page<Project> listProject(Project search, int curPage, int pageSize);

    Integer addUser2Project(Long userId, Long projectId, Integer role);

    Integer removeUserInProject(Long userId, Long projectId);

    Integer modifyUserRoleInProject(Long userId, Long projectId, Integer newRole);
}
