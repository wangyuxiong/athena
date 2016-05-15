package com.metaboy.athena.service.test;

import com.metaboy.athena.model.Project;
import com.metaboy.athena.service.ProjectService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by metaboy on 16/5/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/conf/spring.xml")
public class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;

    @Test
    public void testProjectService() {
        System.out.println("start to test .......");
        Project project = new Project();
        project.setProductId(1L);
        project.setProjectName("test_project");
        project.setProjectDesc("test_project_desc");
        project.setProjectStage(1);
        project.setProjectType(1);
        project.setProjectStartDate(new Date(2016, 2, 1));
        project.setProjectEndDate(new Date(2016, 3, 1));

        Long projectId = projectService.addProject(project);
        System.out.println(projectId);
        Assert.assertTrue(projectId > 0);


    }
}
