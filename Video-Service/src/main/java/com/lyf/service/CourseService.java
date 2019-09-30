package com.lyf.service;

import com.lyf.entity.Course;
import com.lyf.entity.CourseQueryVo;
import com.lyf.entity.Subject;

import java.util.List;

/**
 * @author 喜闻乐见i
 */
public interface CourseService {
    /**
     * 查询所有课程信息
     *
     * @return 返回一个Course类型的 list集合
     */
    List<Course> selectAllCourse();

    /**
     * 过滤并查询所有满足条件的数据，并返回满足的数据
     *
     * @param queryVo  附带查询条件的一个实体类
     * @param page
     * @param pageSize
     * @return 返回一个List集合
     */
    List<Course> selectListByQueryVo(CourseQueryVo queryVo, int page, int pageSize);

    /**
     * 查询Subject所有数据
     *
     * @return 返回一个list集合
     */
    List<Subject> selectAllSubject();

    /**
     * 根据id删除信息
     *
     * @param id Integer类型
     * @return 返回删除行数
     */
    int deleteById(Integer id);

    /**
     * 添加或删除
     *
     * @param course Course类型数据
     * @return 返回受影响行数
     */
    int saveOrUpdate(Course course);

    /**
     * 根据id查询Course信息
     *
     * @param id int类型id
     * @return 返回Course信息
     */
    Course selectById(int id);

    /**
     * 根据科目id查询对应所有课程
     *
     * @param subjectId 科目id
     * @return 返回Course类型List集合
     */
    List<Course> selectCourseBySubjectId(Integer subjectId);

}
