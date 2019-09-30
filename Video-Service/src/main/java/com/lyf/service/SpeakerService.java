package com.lyf.service;

import com.lyf.entity.Speaker;
import com.lyf.entity.SpeakerQueryVo;

import java.util.List;

/**
 * @author 喜闻乐见i
 */
public interface SpeakerService {
    /**
     * 查询全部讲师信息
     *
     * @return 返回一个Speaker类型的List集合
     */
    List<Speaker> selectAllSpeaker();

    /**
     * 过滤并查询所有满足条件的数据，并返回满足的个数
     *
     * @param queryVo 附带查询条件的一个实体类
     * @return 返回一个int类型的 数据个数
     */
    int selectQueryVoNum(SpeakerQueryVo queryVo);

    /**
     * 过滤并查询所有 Speaker 信息，并返回一个list集合
     *
     * @param queryVo 附带查询条件的一个实体类
     * @return 返回一个Video类型的List
     */
    List<Speaker> selectListByQueryVo(SpeakerQueryVo queryVo);

    /**
     * 修改或添加方法
     *
     * @param speaker Speaker类型的讲师信息
     */
    void saveOrUpdate(Speaker speaker);

    /**
     * 根据id删除
     *
     * @param id int类型
     */
    void delById(int id);

    /**
     * 批量删除数据
     *
     * @param ids Integer类型数组
     * @return 返回删除行数
     */
    int delBatchSpeaker(Integer[] ids);

    /**
     * 根据id查询信息
     *
     * @param id Integer类型id
     * @return 返回一个Speaker类型的数据
     */
    Speaker selectById(Integer id);
}
