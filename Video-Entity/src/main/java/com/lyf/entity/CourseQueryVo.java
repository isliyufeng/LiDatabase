package com.lyf.entity;

/**
 * @author 喜闻乐见i
 */
public class CourseQueryVo {
    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    private Integer subjectId;

    public CourseQueryVo() {
    }


    @Override
    public String toString() {
        return "CourseQueryVo{" +
                "subjectId=" + subjectId +
                '}';
    }
}
