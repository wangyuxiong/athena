package com.metaboy.athena.service;

import com.metaboy.athena.model.Constant.RoleType;
import com.metaboy.athena.model.Page;
import com.metaboy.athena.model.Project;
import com.metaboy.athena.model.ProjectRole;
import com.metaboy.athena.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by metaboy on 16/5/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/conf/spring.xml")
public class ProjectServiceTest {

    private static String projectName = "test_project";
    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;
    private Long userId;

    @Before
    public void setUp() throws Exception {
        projectService.deleteProjectByName(projectName);

        User user = new User();
        String userName = "metaboy_test";
        String passwd = "test";
        String email = "yxiong.wang@gmail.com";

        user.setUserName(userName);
        user.setPasswd(passwd);
        user.setEmail(email);

        userId = userService.addUser(user);
    }

    @After
    public void tearDown() throws Exception {
        userService.deleteUser(userId);
    }

    @Test
    public void testProjectService() {
        System.out.println("start to test .......");
        Project project = new Project();
        project.setProductId(1L);
        project.setProjectName(projectName);
        project.setProjectDesc("test_project_desc");
        project.setProjectStage(1);
        project.setProjectType(1);
        project.setProjectStartDate(new Date(2016, 2, 1));
        project.setProjectEndDate(new Date(2016, 3, 1));

        Long projectId = projectService.addProject(project);
        System.out.println(project.toString());
        Assert.assertTrue(projectId > 0);

        Project projectGetMethod = projectService.getProjectById(projectId);
        Assert.assertEquals(projectGetMethod.getProjectName(), project.getProjectName());
        Assert.assertEquals(projectGetMethod.getProjectDesc(), project.getProjectDesc());
        Assert.assertEquals(projectGetMethod.getProjectStage(), project.getProjectStage());
        Assert.assertEquals(projectGetMethod.getProjectType(), project.getProjectType());
        Assert.assertEquals(projectGetMethod.getProjectStartDate(), project.getProjectStartDate());
        Assert.assertEquals(projectGetMethod.getProjectEndDate(), project.getProjectEndDate());


        projectGetMethod.setProjectDesc("");
        int ret = projectService.modifyProjectInfo(projectGetMethod);
        Assert.assertEquals(1, ret);

        Project search = new Project();
        search.setProductId(1L);
        Page<Project> projectPage = projectService.listProject(search, 1, 5);
        Assert.assertEquals(1, projectPage.getTotalCount());

        System.out.println("start to add user role");
        ret = projectService.addUser2Project(userId, projectId, RoleType.OWNER.getValue());
        Assert.assertEquals(ret, 1);
        int roleValue = projectService.getUserRoleInProject(userId, projectId);
        Assert.assertEquals(roleValue, RoleType.OWNER.getValue());

        System.out.println("start to check modify user role");
        ret = projectService.modifyUserRoleInProject(userId, projectId, RoleType.PM.getValue());
        Assert.assertEquals(ret, 1);

        System.out.println("start to check get user role");
        roleValue = projectService.getUserRoleInProject(userId, projectId);
        Assert.assertEquals(roleValue, RoleType.PM.getValue());


        System.out.println("start to check list user role");
        List<ProjectRole> pos = projectService.listUserInProject(projectId);
        Assert.assertEquals(pos.size(), 1);

        System.out.println("start to check remove user role");
        ret = projectService.removeUserInProject(userId, projectId);
        Assert.assertEquals(ret, 1);

        ret = projectService.removeProject(projectId);
        Assert.assertEquals(ret, 1);

        Project projectNotUsed = projectService.getProjectById(projectId);
        Assert.assertEquals(projectNotUsed.getStatus().intValue(), -1);

        ret = projectService.deleteProject(projectId);
        Assert.assertEquals(ret, 1);
        Project projectDelete = projectService.getProjectById(projectId);
        Assert.assertNull(projectDelete);


    }


}
