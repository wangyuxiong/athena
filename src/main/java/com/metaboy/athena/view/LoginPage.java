package com.metaboy.athena.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by metaboy on 16/5/24.
 */
@Controller
public class LoginPage {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView indexView() {
        return new ModelAndView("login");
    }
}
