package com.lyf.entity;

/**
 * 此实体是个为了接收查询条件方便，产生的实体
 *
 * @author 喜闻乐见i
 */
public class VideoQueryVo {

    private Integer page = 1;
    private Integer rows = 5;
    private Integer begin = 0;

    // 我要查询所有数据，但是页面中有过滤的条件，所以我应该在此处有过滤条件的字段

    private String title;
    private int spearkerId;
    private int courseId;

    public VideoQueryVo() {
    }

    @Override
    public String toString() {
        return "VideoQueryVo{" +
                "page=" + page +
                ", rows=" + rows +
                ", begin=" + begin +
                ", title='" + title + '\'' +
                ", spearkerId=" + spearkerId +
                ", courseId=" + courseId +
                '}';
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSpearkerId() {
        return spearkerId;
    }

    public void setSpearkerId(int spearkerId) {
        this.spearkerId = spearkerId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
