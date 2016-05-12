package com.metaboy.athena.api;

import com.google.common.base.CharMatcher;
import com.metaboy.athena.model.RestResult;
import com.metaboy.athena.model.User;
import com.metaboy.athena.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by metaboy on 16/4/27.
 */

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RestResult userAdd(@RequestBody User user) {
        checkNotNull(user.getUserName(), "User name is required.");
        checkNotNull(user.getPasswd(), "Password is required.");
        checkNotNull(user.getEmail(), "Email is required.");

        checkArgument(!CharMatcher.WHITESPACE.matchesAllOf(user.getUserName()), "User name can not be empty.");
        checkArgument(!CharMatcher.WHITESPACE.matchesAllOf(user.getPasswd()), "Password me can not be empty.");
        checkArgument(!CharMatcher.WHITESPACE.matchesAllOf(user.getEmail()), "Email can not be empty.");


        Long id = userService.addUser(user);
        return RestResult.ok("add user success", id);
    }
}
