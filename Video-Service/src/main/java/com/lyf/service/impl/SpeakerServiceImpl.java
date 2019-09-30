package com.lyf.service.impl;

import com.lyf.entity.Speaker;
import com.lyf.entity.SpeakerQueryVo;
import com.lyf.mapper.SpeakerMapper;
import com.lyf.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author 喜闻乐见i
 */
@Service
public class SpeakerServiceImpl implements SpeakerService {
    @Autowired
    SpeakerMapper mapper;

    public List<Speaker> selectAllSpeaker() {
        List<Speaker> list = mapper.selectAllSpeaker();
        return list;
    }

    public int selectQueryVoNum(SpeakerQueryVo queryVo) {
        int num = mapper.selectQueryVoNum(queryVo);
        return num;
    }

    public List<Speaker> selectListByQueryVo(SpeakerQueryVo queryVo) {
        List<Speaker> speakers = mapper.selectListByQueryVo(queryVo);
        return speakers;
    }

    public void saveOrUpdate(Speaker speaker) {
        if (speaker.getId() == 0) {
            System.out.println("执行了添加方法");
            mapper.save(speaker);
        } else {
            System.out.println("执行了修改方法");
            mapper.update(speaker);
        }
    }

    public void delById(int id) {
        mapper.delById(id);
    }

    public int delBatchSpeaker(Integer[] ids) {
        List<Integer> list = Arrays.asList(ids);
        int result = mapper.delBatchSpeaker(list);
        return result;
    }

    public Speaker selectById(Integer id) {
        Speaker speaker = mapper.selectById(id);
        return speaker;
    }
}
