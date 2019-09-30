package com.lyf.controller;

import com.github.pagehelper.PageInfo;
import com.lyf.entity.Course;
import com.lyf.entity.CourseQueryVo;
import com.lyf.entity.Subject;
import com.lyf.entity.Video;
import com.lyf.service.CourseService;
import com.lyf.service.SubjectService;
import com.lyf.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 喜闻乐见i
 */
@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @Autowired
    SubjectService subjectService;

    @Autowired
    VideoService videoService;

    @RequestMapping("/list")
    public String list(CourseQueryVo queryVo,
                       @RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "5") int pageSize,
                       Model model) {
        System.out.println("/course/list : " + queryVo);
        
        List<Course> list = courseService.selectListByQueryVo(queryVo, page, pageSize);
        PageInfo<Course> pageInfo = new PageInfo<Course>(list);
        model.addAttribute("pageInfo", pageInfo);

        List<Subject> subjectList = courseService.selectAllSubject();
        model.addAttribute("subjectList", subjectList);
        return "/behind/CourseList.jsp";
    }


    @RequestMapping("/addCourse")
    public String addCourse(Model model) {
        List<Subject> subjects = courseService.selectAllSubject();
        model.addAttribute("subjects", subjects);
        return "/behind/addCourse.jsp";
    }

    @RequestMapping("/courseDel")
    @ResponseBody
    public String courseDel(Integer id) {
        int result = courseService.deleteById(id);
        System.out.println(result);
        return result > 0 ? "success" : "fail";
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public String saveOrUpdate(Course course) {
        System.out.println(course);
        int result = courseService.saveOrUpdate(course);
        System.out.println(result);
        return "success";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        System.out.println("要修改的id为：" + id);
        Course course = courseService.selectById(id);
        model.addAttribute("course", course);
        List<Subject> subjects = courseService.selectAllSubject();
        model.addAttribute("subjects", subjects);
        return "/behind/addCourse.jsp";
    }

    @RequestMapping("/beforeList")
    public String beforeList(Integer subjectId, Model model) {
        Subject subject =  subjectService.getSubjectById(subjectId);
        List<Course> courseList = courseService.selectCourseBySubjectId(subjectId);
        for (Course course:courseList) {
            List<Video> videoList = videoService.getVideoListByCourseId(course.getId());
            course.setVideoList(videoList);
        }
        subject.setCourseList(courseList);
        model.addAttribute("subject",subject);
        return "/before/course.jsp";
    }
}
