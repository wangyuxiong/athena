package com.metaboy.athena.api;

import com.google.common.base.CharMatcher;
import com.metaboy.athena.model.RestResult;
import com.metaboy.athena.model.User;
import com.metaboy.athena.service.UserService;
import com.metaboy.athena.utils.DecryptionUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by metaboy on 16/4/27.
 */

@Controller
@RequestMapping(value = "/api")
public class UserController {

    private static final Log LOGGER = LogFactory.getLog(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public RestResult userAdd(@RequestBody User user) {
        checkNotNull(user.getUserName(), "User name is required.");
        checkNotNull(user.getPasswd(), "Password is required.");
        checkNotNull(user.getEmail(), "Email is required.");

        checkArgument(!CharMatcher.WHITESPACE.matchesAllOf(user.getUserName()), "User name can not be empty.");
        checkArgument(!CharMatcher.WHITESPACE.matchesAllOf(user.getPasswd()), "Password me can not be empty.");
        checkArgument(!CharMatcher.WHITESPACE.matchesAllOf(user.getEmail()), "Email can not be empty.");


        Long id = userService.addUser(user);
        if (id > 0) {
            return RestResult.ok("add user success", id);
        } else {
            return RestResult.fail("add user failed", null);
        }
    }


    @RequestMapping(value = "/user/{name:.*}", method = RequestMethod.PUT)
    public RestResult userUpdate(@PathVariable(value = "name") String name,
                                 @RequestBody User user) {

        user.setUserName(name);
        user.setGmtModified(new Date());

        int n = userService.modifyUserInfo(user);

        if (n == 0) {
            return RestResult.fail("User not found.", null);
        } else if (n == 1) {
            return RestResult.ok("Update user success.", null);
        } else {
            return RestResult.fail("Update user failed.", null);
        }
    }

    @RequestMapping(value = "/user/{name:.*}", method = RequestMethod.POST)
    public RestResult userDetails(
            @PathVariable(value = "name") String name) {

        User user = userService.getUserByUser(name);
        if (user == null) {
            return RestResult.fail(String.format("User[%s] Is Not Exist.", name), null);
        } else {
            return RestResult.ok("", user);
        }
    }

    @RequestMapping(value = "/user/{name:.*}", method = RequestMethod.DELETE)
    public RestResult userDelete(
            @PathVariable(value = "name") String name) {

        User user = userService.getUserByUser(name);
        int deleteRows = userService.deleteUser(user.getId());
        if (deleteRows == 0) {
            return RestResult.fail(String.format("User[%s] Is Not Exist.", name), null);
        } else {
            return RestResult.ok("Delete user success.", null);
        }
    }
}
