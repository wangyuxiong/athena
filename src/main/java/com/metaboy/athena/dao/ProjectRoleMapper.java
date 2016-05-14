package com.metaboy.athena.dao;

import com.metaboy.athena.model.ProjectRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by metaboy on 16/5/14.
 */
@Repository
public interface ProjectRoleMapper {

    Integer addProjectRole(ProjectRole projectRole);

    Integer deleteProjectRole(ProjectRole projectRole);

    Integer modifyProjectRole(ProjectRole projectRole);

    List<ProjectRole> getProjectRolesByProId(Long projectId);
}
