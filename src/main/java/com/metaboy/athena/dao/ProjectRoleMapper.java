package com.metaboy.athena.dao;

import com.metaboy.athena.model.ProjectRole;
import org.apache.ibatis.annotations.Param;
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

    List<ProjectRole> getProjectRolesByProId(@Param(value = "projectId") Long projectId);

    Integer getUserRoleInProject(@Param(value = "userId") Long userId,
                                 @Param(value = "projectId") Long projectId);
}
