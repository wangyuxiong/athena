package com.metaboy.athena.service.impl;

import com.metaboy.athena.dao.ProjectMapper;
import com.metaboy.athena.dao.ProjectRoleMapper;
import com.metaboy.athena.model.Page;
import com.metaboy.athena.model.Project;
import com.metaboy.athena.model.ProjectRole;
import com.metaboy.athena.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by metaboy on 16/5/15.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectMapper projectMapper;

    @Autowired
    ProjectRoleMapper projectRoleMapper;

    @Override
    public Long addProject(Project project) {
        int ret = projectMapper.addProject(project);
        if (ret == 1) {
            return project.getId();
        } else {
            return -1L;
        }
    }

    @Override
    public Project getProjectById(Long projectId) {
        return projectMapper.getProjectById(projectId);
    }


    @Override
    public int deleteProject(Long projectId) {
        return projectMapper.deleteProject(projectId);
    }

    public int deleteProjectByName(String projectName) {
        return projectMapper.deleteProjectByName(projectName);
    }

    @Override
    public int removeProject(Long projectId) {
        return projectMapper.removeProject(projectId);
    }

    public int modifyProjectInfo(Project project) {
        return projectMapper.modifyProject(project);
    }

    @Override
    public Page<Project> listProject(Project search, int curPage, int pageSize) {
        Page<Project> page = new Page<Project>();
        page.setCurPage(curPage);
        page.setPageSize(pageSize);
        Integer count = projectMapper.countSearchProject(search);
        if (count > 0) {
            List<Project> list = projectMapper.projectPage(search, curPage * pageSize, pageSize);
            page.setResult(list);
            page.setTotalCount(count);
        } else {
            page.setResult(Collections.<Project>emptyList());
        }
        return page;
    }

    @Override
    public int addUser2Project(Long userId, Long projectId, Integer role) {
        ProjectRole projectRole = new ProjectRole();
        projectRole.setProjectId(projectId);
        projectRole.setUserId(userId);
        projectRole.setRole(role);

        return projectRoleMapper.addProjectRole(projectRole);

    }

    @Override
    public int removeUserInProject(Long userId, Long projectId) {
        ProjectRole projectRole = new ProjectRole();
        projectRole.setUserId(userId);
        projectRole.setProjectId(projectId);
        return projectRoleMapper.deleteProjectRole(projectRole);
    }

    @Override
    public int modifyUserRoleInProject(Long userId, Long projectId, Integer newRole) {
        ProjectRole projectRole = new ProjectRole();
        projectRole.setUserId(userId);
        projectRole.setProjectId(projectId);
        projectRole.setRole(newRole);
        return projectRoleMapper.modifyProjectRole(projectRole);
    }

    @Override
    public int getUserRoleInProject(Long userId, Long projectId) {
        return projectRoleMapper.getUserRoleInProject(userId, projectId);
    }

    @Override
    public List<ProjectRole> listUserInProject(Long projectId) {
        return projectRoleMapper.getProjectRolesByProId(projectId);
    }

}
