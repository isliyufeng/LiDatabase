package com.lyf.mapper;

import com.lyf.entity.Video;
import com.lyf.entity.VideoQueryVo;

import java.util.List;

/**
 * @author 喜闻乐见i
 */
public interface VideoMapper {

    /**
     * 查询所有Video信息，并返回一个list集合
     *
     * @param queryVo 附带查询条件的一个实体类
     * @return 返回一个Video类型的List
     */
    List<Video> selectListByQueryVo(VideoQueryVo queryVo);

    /**
     * 根据id删除video信息
     *
     * @param id Integer类型id
     * @return int类型受影响行数
     */
    int delById(Integer id);

    /**
     * 过滤并查询所有满足条件的数据，并返回满足的个数
     *
     * @param queryVo 附带查询条件的一个实体类
     * @return 返回一个int类型的 数据个数
     */
    int selectQueryVoNum(VideoQueryVo queryVo);





    /**
     * 添加视频
     *
     * @param video 视频信息
     */
    void save(Video video);

    /**
     * 修改视频信息
     *
     * @param video 视频信息
     */
    void update(Video video);

    /**
     * 根据id查询video信息
     *
     * @param id Integer类型id
     * @return Video类型的数据
     */
    Video selectById(Integer id);

    /**
     * 批量删除指定id数据
     *
     * @param list 指定id的集合
     * @return 删除成功的行数
     */
    int delBatchVideos(List<Integer> list);

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
