package com.lyf.mapper;

import com.lyf.entity.Speaker;
import com.lyf.entity.SpeakerQueryVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 喜闻乐见i
 */
public interface SpeakerMapper {
    /**
     * 查询所有Speaker信息
     *
     * @return Speaker类型的list集合
     */
    List<Speaker> selectAllSpeaker();

    /**
     * 查询过滤之后的数据个数
     *
     * @param queryVo 附带过滤条件的实体类
     * @return 返回满足条件的个数
     */
    int selectQueryVoNum(SpeakerQueryVo queryVo);

    /**
     * 查询所有Speaker信息，并返回一个list集合
     *
     * @param queryVo 附带查询条件的一个实体类
     * @return 返回一个Speaker类型的List
     */
    List<Speaker> selectListByQueryVo(SpeakerQueryVo queryVo);


    /**
     * 根据id查询对应的speaker信息
     *
     * @param id int类型
     * @return 返回Speaker类型数据
     */
    @Select("select * from speaker where id = #{id}")
    @Results(id = "speakerByIdMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "speakerName", column = "speaker_name"),
            @Result(property = "speakerDesc", column = "speaker_desc"),
            @Result(property = "speakerJob", column = "speaker_job"),
            @Result(property = "headImgUrl", column = "head_img_url")
    })
    Speaker selectById(int id);

    /**
     * 添加方法
     *
     * @param speaker Speaker类型的数据
     * @return 添加的信息的id
     */
    @Insert("insert into speaker values (null, #{speakerName}, #{speakerDesc}, #{speakerJob}, #{headImgUrl})")
    void save(Speaker speaker);

    /**
     * 修改方法
     *
     * @param speaker speaker类型的数据
     */
    @Update("update speaker set speaker_name = #{speakerName}, speaker_desc = #{speakerDesc}, " +
            "speaker_job = #{speakerJob}, head_img_url = #{headImgUrl} where id = #{id}")
    void update(Speaker speaker);

    /**
     * 根据id删除指定信息
     *
     * @param id int类型
     */
    @Delete("delete from speaker where id = #{id}")
    void delById(int id);

    /**
     * 批量删除
     *
     * @param list 装有需要删除的数据的id的list集合
     * @return 返回删除条数
     */
    @Delete("<script>" +
            "delete from speaker where id in\n" +
            "        <foreach collection=\"list\" item=\"id\" separator=\",\" open=\"(\" close=\")\">\n" +
            "            #{id}\n" +
            "        </foreach>"+
            "</script>")
    int delBatchSpeaker(List<Integer> list);

}
