package com.lyf.service.impl;

import com.lyf.entity.Video;
import com.lyf.entity.VideoQueryVo;
import com.lyf.mapper.VideoMapper;
import com.lyf.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author 喜闻乐见i
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoMapper mapper;

    public void delById(Integer id) {
        mapper.delById(id);
    }

    public List<Video> selectListByQueryVo(VideoQueryVo queryVo) {
        List<Video> videos = mapper.selectListByQueryVo(queryVo);
        return videos;
    }

    public int selectQueryVoNum(VideoQueryVo queryVo) {
        int num = mapper.selectQueryVoNum(queryVo);
        return num;
    }

    public void saveOrUpdate(Video video) {
        if (video.getId() == 0) {
            System.out.println("我开始执行保存方法！");
            mapper.save(video);
        } else {
            System.out.println("我开始执行更改方法！");
            mapper.update(video);
        }
    }

    public Video selectById(Integer id) {
        Video video = mapper.selectById(id);
        return video;
    }

    public int delBatchVideos(Integer[] ids) {
        // 批量删除需要一个装有list集合 Arrays.asList(ids)  将数组变成一个list集合，但是该集合是只读的
        List<Integer> list = Arrays.asList(ids);
        int result = mapper.delBatchVideos(list);
        return result;
    }

    public List<Video> getVideoListByCourseId(int id) {
        List<Video> list = mapper.getVideoListByCourseId(id);
        return list;
    }

    public Video getVideoById(Integer videoId) {
        return mapper.getVideoById(videoId);

    }
}
