package com.metaboy.athena.dao;

import com.metaboy.athena.model.Project;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by metaboy on 16/5/14.
 */
@Repository
public interface ProjectMapper {
    Integer addProject(Project project);

    Integer removeProject(Long projectId);

    Integer deleteProject(Long projectId);

    Integer deleteProjectByName(@Param("projectName") String projectName);

    Integer modifyProject(Project project);

    Project getProjectById(Long projectId);

//    List<Project> listProject(@Param("project") Project projectSearch);

    List<Project> projectPage(@Param("project") Project projectSearch, @Param("offset") int offset, @Param("pageSize") int pageSize);

    int countSearchProject(@Param("project") Project projectSearch);
}
