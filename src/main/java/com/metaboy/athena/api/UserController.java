package com.metaboy.athena.api;

import com.metaboy.athena.model.User;
import com.metaboy.athena.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by metaboy on 16/4/27.
 */

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User userAdd(@RequestBody User user,
                        @RequestParam(value = "_user", required = true) String userName) {
        userService.addUser(user);
        return user;
    }
}
