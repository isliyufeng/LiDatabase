package com.lyf.mapper;

import com.lyf.entity.Subject;

/**
 * @author 喜闻乐见i
 */
public interface SubjectMapper {
    /**
     * 根据Id获取对应科目
     *
     * @param subjectId Integer类型 科目Id
     * @return 返回科目信息
     */
    Subject getSubjectById(Integer subjectId);
}
