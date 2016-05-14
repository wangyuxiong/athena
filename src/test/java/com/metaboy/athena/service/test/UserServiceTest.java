package com.metaboy.athena.service.test;

import com.metaboy.athena.model.User;
import com.metaboy.athena.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by metaboy on 16/5/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/conf/spring.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testUserService() throws Exception {
        System.out.println("start to test .......");
        User user = new User();
        String userName = "metaboy_test";
        String passwd = "test";
        String email = "yxiong.wang@gmail.com";

        String newEmail = "234123806@qq.com";
        String newPasswd = "test123";

        user.setUserName(userName);
        user.setPasswd(passwd);
        user.setEmail(email);

        Long userId = userService.addUser(user);

        assertTrue(userId > 0);
        System.out.println("add user test finished...");

        User userGetFormName = userService.getUserByUser(userName);
        User userGetFromEmail = userService.getUserByEmail(email);

        assertEquals(userGetFormName.getEmail(), userGetFromEmail.getEmail());
        assertEquals(userGetFormName.getUserName(), userGetFromEmail.getUserName());
        assertEquals(userGetFormName.getPasswd(), userGetFromEmail.getPasswd());
        assertEquals(userGetFormName.getStatus(), userGetFromEmail.getStatus());
        assertEquals(userGetFormName.getId(), userGetFromEmail.getId());
        System.out.println(String.format("........... userName: %s, passwd : %s, email: %s, status: %s", userGetFormName.getUserName(), userGetFormName.getPasswd()
                , userGetFormName.getEmail(), userGetFormName.getStatus()));
        System.out.println("get user test finished...");

        userGetFormName.setEmail(newEmail);
        userGetFormName.setPasswd(newPasswd);

        Integer ret = userService.modifyUserInfo(userGetFormName);
        assertTrue(ret == 1);

        userGetFormName = userService.getUserByUser(userName);
        System.out.println(String.format("........... userName: %s, passwd : %s, email: %s, status: %s", userGetFormName.getUserName(), userGetFormName.getPasswd()
                , userGetFormName.getEmail(), userGetFormName.getStatus()));
        System.out.println("modify user test finished...");

        ret = userService.removeUser(userId);

        assertTrue(ret == 1);

        System.out.println("remove user test finished...");

        ret = userService.deleteUser(userId);

        assertTrue(ret == 1);
        User userGetWhenDel = userService.getUserByUser(userName);

        assertNull(userGetWhenDel);
        System.out.println("delete user test finished...");
    }
}