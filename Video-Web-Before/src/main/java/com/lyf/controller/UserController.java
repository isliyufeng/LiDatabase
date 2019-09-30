package com.lyf.controller;

import com.lyf.entity.User;
import com.lyf.service.CourseService;
import com.lyf.service.UserService;
import com.lyf.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author 喜闻乐见i
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    @RequestMapping("/loginUser")
    @ResponseBody
    public String loginUser(User user, HttpSession session) {
        user.setPassword(MD5Utils.getMd5Str(user.getPassword()));
        boolean result = userService.verifyLogin(user);
        session.setAttribute("userAccount", user.getEmail());
        User user1 = userService.getUserByEmail(user.getEmail());
        session.setAttribute("user", user);
        return result ? "success" : "fail";
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute("userAccount");
        return "../../index.jsp";
    }

    @RequestMapping("validateEmail")
    @ResponseBody
    public String validateEmail(String email) {
        System.out.println("邮箱为：" + email);
        boolean result = userService.validateEmail(email);
        return result ? "success" : "fail";
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser(User user, HttpSession session) {
        user.setPassword(MD5Utils.getMd5Str(user.getPassword()));
        String email = user.getEmail();
        int result = userService.insertUser(user);
        session.setAttribute("userAccount", user.getEmail());
        System.out.println("要注册的用户信息：" + user);
        MailUtils.sendMail(email, "您好，欢迎您成为Y先生学习网的会员，请点击 <a href='http://localhost:8080/Videos/index.jsp'>进行登录！</a>！", "Y先生学习网账号注册成功");
        return result > 0 ? "success" : "error";
    }

    @RequestMapping("/showMyProfile")
    public String showMyProfile(HttpSession session, Model model) {
        String userAccount = (String) session.getAttribute("userAccount");
        System.out.println("查询到的Email：" + userAccount);
        User user = userService.getUserByEmail(userAccount);
        System.out.println("查询到的User：" + user);
        model.addAttribute("user", user);
        return "before/my_profile.jsp";
    }

    @RequestMapping("/changeProfile")
    public String changeProfile(HttpSession session, Model model) {
        String userAccount = (String) session.getAttribute("userAccount");
        User user = userService.getUserByEmail(userAccount);
        System.out.println("查询到的User：" + user);
        model.addAttribute("user", user);
        return "before/change_profile.jsp";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user, HttpSession session, Model model) {
        String userAccount = (String) session.getAttribute("userAccount");
        User user1 = userService.getUserByEmail(userAccount);
        user1.setNickname(user.getNickname());
        user1.setSex(user.getSex());
        user1.setBirthday(user.getBirthday());
        user1.setAddress(user.getAddress());
        userService.updateUser(user1);
        model.addAttribute("user", user1);
        return "before/my_profile.jsp";
    }

    @RequestMapping("/changeAvatar")
    public String changeAvatar(HttpSession session, Model model) {
        String userAccount = (String) session.getAttribute("userAccount");
        User user = userService.getUserByEmail(userAccount);
        model.addAttribute("user", user);
        return "/before/change_avatar.jsp";
    }

    @RequestMapping("/upLoadImage")
    public String upLoadImage(MultipartFile image_file, HttpSession session, String x1, String x2, String y1, String y2) {
        // 上传照片
        System.out.println(image_file.getOriginalFilename());
        String originalFilename = image_file.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);
        String newName = UUIDUtils.getUUID() + suffix;
        System.out.println(newName);
        try {
            image_file.transferTo(new File(InfoUtils.getProperties("IMG_PATH"), newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 截取图片的坐标
        System.out.println(x1);
        System.out.println(x2);
        System.out.println(y1);
        System.out.println(y2);
        float _x1 = Float.valueOf(x1);
        float _x2 = Float.valueOf(x2);
        float _y1 = Float.valueOf(y1);
        float _y2 = Float.valueOf(y2);
        // 裁剪照片
        ImageCut imageCut = new ImageCut();
        imageCut.cutImage(InfoUtils.getProperties("IMG_PATH") + "\\" + newName, (int) _x1, (int) _y1, (int) (_x2 - _x1), (int) (_y2 - _y1));
        // 更新数据
        String email = (String) session.getAttribute("userAccount");
        User user = new User();
        user.setEmail(email);
        user.setImgurl(InfoUtils.getProperties("IMG_URL") + newName);
        userService.updateUserImgUrl(user);
        return "redirect:/user/showMyProfile";
    }

    @RequestMapping("/passwordSafe")
    public String passwordSafe(HttpSession session, Model model) {
        String userAccount = (String) session.getAttribute("userAccount");
        System.out.println("要修改密码的邮箱为：" + userAccount);
        User user = userService.getUserByEmail(userAccount);
        model.addAttribute("user", user);
        return "/before/password_safe.jsp";
    }

    @RequestMapping("/updatePassword")
    public String updatePassword(String newPassword, HttpSession session) {
        String userAccount = (String) session.getAttribute("userAccount");
        User user = new User();
        user.setEmail(userAccount);
        user.setPassword(MD5Utils.getMd5Str(newPassword));
        userService.updateUser(user);
        return "redirect:/user/showMyProfile";
    }


    @RequestMapping("/validatePassword")
    @ResponseBody
    public String validatePassword(String password, HttpSession session) {
        String userAccount = (String) session.getAttribute("userAccount");
        User user = new User();
        user.setEmail(userAccount);
        user.setPassword(MD5Utils.getMd5Str(password));
        boolean result = userService.verifyLogin(user);
        return result ? "success" : "fail";
    }

    @RequestMapping("/forgetPassword")
    public String forgetPassword() {
        return "/before/forget_password.jsp";
    }

    @RequestMapping("/validateEmailCode")
    public String validateEmailCode(String email, String code, Model model) {
        model.addAttribute("email", email);
        return "/before/reset_password.jsp";
    }

    @RequestMapping("/resetPassword")
    public String resetPassword(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(MD5Utils.getMd5Str(password));
        userService.updateUser(user);
        return "../../index.jsp";
    }

}
