package com.lyf.service.impl;

import com.github.pagehelper.PageHelper;
import com.lyf.entity.Course;
import com.lyf.entity.CourseQueryVo;
import com.lyf.entity.Subject;
import com.lyf.mapper.CourseMapper;
import com.lyf.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 喜闻乐见i
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseMapper mapper;

    public List<Course> selectAllCourse() {
        List<Course> list = mapper.selectAllCourse();
        return list;
    }

    public List<Course> selectListByQueryVo(CourseQueryVo queryVo, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Course> list = mapper.selectListByQueryVo(queryVo);
        return list;
    }

    public List<Subject> selectAllSubject() {
        List<Subject> list = mapper.selectAllSubject();
        return list;
    }

    public int deleteById(Integer id) {
        int result = mapper.deleteById(id);
        return result;
    }

    public int saveOrUpdate(Course course) {
        int result = 0;
        if (course.getId() == 0) {
            System.out.println("添加");
            result = mapper.addCourse(course);
        } else {
            result = mapper.updateCourse(course);
        }
        return result;
    }

    public Course selectById(int id) {
        Course course = mapper.selectById(id);
        return course;
    }

    public List<Course> selectCourseBySubjectId(Integer subjectId) {
        List<Course> list = mapper.selectCourseBySubjectId(subjectId);
        return list;
    }
}
