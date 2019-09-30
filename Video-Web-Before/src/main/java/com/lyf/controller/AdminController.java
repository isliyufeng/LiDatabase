package com.lyf.controller;

import com.lyf.service.AdminService;
import com.lyf.utils.MD5Utils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author 喜闻乐见i
 */
@Api(value = "管理员后台登录的接口", tags = "用户操作接口登录，注册，退出登录等功能！")
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    /**
     * 验证登录
     *
     * @return 成功返回success，失败返回fail
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password, HttpSession session) {
        System.out.println(MD5Utils.getMd5Str(password));
        if (adminService.login(username, MD5Utils.getMd5Str(password))) {
            session.setAttribute("USERNAME", username);
            return "success";
        }
        return "fail";
    }

    /**
     * 展示登录页面
     *
     * @return 登录页面
     */
    @RequestMapping("/showLogin")
    public String showLogin() {
        return "behind/login.jsp";
    }


    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        session.removeAttribute("USERNAME");
        return "redirect:/admin/showLogin";
    }

}
