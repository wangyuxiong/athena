package com.metaboy.athena.service;

import com.metaboy.athena.model.Page;
import com.metaboy.athena.model.Project;
import com.metaboy.athena.model.ProjectRole;

import java.util.List;

/**
 * Created by metaboy on 16/5/15.
 */
public interface ProjectService {

    Long addProject(Project project);

    Project getProjectById(Long projectId);

    int modifyProjectInfo(Project project);

    int deleteProject(Long projectId);

    int deleteProjectByName(String projectName);

    int removeProject(Long projectId);

    Page<Project> listProject(Project search, int curPage, int pageSize);

    int addUser2Project(Long userId, Long projectId, Integer role);

    int removeUserInProject(Long userId, Long projectId);

    int modifyUserRoleInProject(Long userId, Long projectId, Integer newRole);

    int getUserRoleInProject(Long userId, Long projectId);

    List<ProjectRole> listUserInProject(Long projectId);
}
