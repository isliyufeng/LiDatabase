package com.lyf.mapper;

import com.lyf.entity.Course;
import com.lyf.entity.CourseQueryVo;
import com.lyf.entity.Subject;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 喜闻乐见i
 */
public interface CourseMapper {
    /**
     * 查询所有的Course信息
     * @return 返回一个Course类型的list集合
     */
    List<Course> selectAllCourse();

    /**
     * 过滤并查询所有满足条件的数据，并返回满足的数据
     *
     * @param queryVo 附带查询条件的一个实体类
     * @return 返回一个List集合
     */
    List<Course> selectListByQueryVo(CourseQueryVo queryVo);

    /**
     * 查询Subject所有数据
     * @return 返回一个list集合
     */
    @Results(id = "subjectMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "subjectName", column = "subject_name")
    })
    @Select("select * from subject")
    List<Subject> selectAllSubject();

    /**
     * 根据id删除信息
     *
     * @param id Integer类型
     * @return 返回删除行数
     */
    @Delete("delete from course where id = #{id}")
    int deleteById(Integer id);

    /**
     * 添加
     *
     * @param course Course类型数据
     * @return 返回受影响行数
     */
    @Results(id = "course", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "courseTitle", column = "course_title"),
            @Result(property = "courseDesc", column = "course_desc"),
            @Result(property = "subjectId", column = "subject_id")
    })
    @Insert("insert into course values (null, #{courseTitle}, #{courseDesc}, #{subjectId})")
    int addCourse(Course course);

    /**
     * 修改
     *
     * @param course Course类型数据
     * @return 返回受影响行数
     */
    @Update("update course set course_title = #{courseTitle}, course_desc = #{courseDesc}, " +
            "subject_id = #{subjectId} where id = #{id}")
    int updateCourse(Course course);

    /**
     * 根据id查询Course信息
     *
     * @param id int类型id
     * @return 返回Course信息
     */
    @Results(id = "selectById", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "courseTitle", column = "course_title"),
            @Result(property = "courseDesc", column = "course_desc"),
            @Result(property = "subjectId", column = "subject_id")
    })
    @Select("select * from course where id = #{id}")
    Course selectById(int id);

    /**
     * 根据科目id查询对应所有课程
     *
     * @param subjectId 科目id
     * @return 返回Course类型List集合
     */
    List<Course> selectCourseBySubjectId(Integer subjectId);
}
