package com.metaboy.athena.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by metaboy on 16/4/27.
 */

@Controller
public class IndexPage {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultIndex() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView indexView() {
        return new ModelAndView("index");
    }
}
