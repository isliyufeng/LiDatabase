package com.lyf.service;

import com.lyf.entity.Video;
import com.lyf.entity.VideoQueryVo;

import java.util.List;

/**
 * @author 喜闻乐见i
 */
public interface VideoService {

    /**
     * 根据id删除对应 video信息
     *
     * @param id Integer类型id
     */
    void delById(Integer id);

    /**
     * 过滤并查询所有Video信息，并返回一个list集合
     *
     * @param queryVo 附带查询条件的一个实体类
     * @return 返回一个Video类型的List
     */
    List<Video> selectListByQueryVo(VideoQueryVo queryVo);

    /**
     * 过滤并查询所有满足条件的数据，并返回满足的个数
     *
     * @param queryVo 附带查询条件的一个实体类
     * @return 返回一个int类型的 数据个数
     */
    int selectQueryVoNum(VideoQueryVo queryVo);

    /**
     * 修改或保存
     *
     * @param video 需要保存的信息
     */
    void saveOrUpdate(Video video);

    /**
     * 根据id查询video信息
     *
     * @param id Integer类型id
     * @return 返回一个Video类型的数据
     */
    Video selectById(Integer id);

    /**
     * 批量删除指定id数据
     *
     * @param ids 指定id的数组
     * @return 删除成功的行数
     */
    int delBatchVideos(Integer[] ids);

    /**
     * 通过课程id查询视频集合
     *
     * @param id 课程id
     * @return Video类型的List集合
     */
    List<Video> getVideoListByCourseId(int id);

    /**
     * 通过视频id查询视频信息
     * @param videoId
     * @return
     */
    Video getVideoById(Integer videoId);
}
