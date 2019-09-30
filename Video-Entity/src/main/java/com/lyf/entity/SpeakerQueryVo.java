package com.lyf.entity;

/**
 * @author 喜闻乐见i
 */
public class SpeakerQueryVo {
    private int page = 1;
    private int rows = 5;
    private int begin = 0;
    private String speakerName;

    public SpeakerQueryVo() {
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }
}
