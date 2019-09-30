package com.lyf.entity;

import com.lyf.utils.StringUtils;

/**
 * @author 喜闻乐见i
 */
public class Video {
    private int id;
    private String title;
    private String detail;
    private int time;
    private int spearkerId;
    private String speakerName;
    private int courseId;
    private String videoUrl;
    private String imageUrl;
    private int playNum;
    private String showTime;
    private Speaker speaker;

    public Video() {
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", time=" + time +
                ", spearkerId=" + spearkerId +
                ", speakerName='" + speakerName + '\'' +
                ", courseId=" + courseId +
                ", videoUrl='" + videoUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", playNum=" + playNum +
                ", showTime='" + showTime + '\'' +
                ", speaker=" + speaker +
                '}';
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSpearkerId() {
        return spearkerId;
    }

    public void setSpearkerId(int spearkerId) {
        this.spearkerId = spearkerId;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPlayNum() {
        return playNum;
    }

    public void setPlayNum(int playNum) {
        this.playNum = playNum;
    }

    public String getShowTime() {
        return StringUtils.getStrTime(this.getTime());
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
