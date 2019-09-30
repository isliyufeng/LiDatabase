package com.lyf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 喜闻乐见i
 */
@Controller
public class ErrorController {

    @RequestMapping("*")
    public String showError(){
        return "404.jsp";
    }
}
