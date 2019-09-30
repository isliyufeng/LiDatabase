package com.lyf.service.impl;

import com.lyf.entity.Subject;
import com.lyf.mapper.SubjectMapper;
import com.lyf.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 喜闻乐见i
 */
@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectMapper mapper;

    public Subject getSubjectById(Integer subjectId) {
        Subject subject = mapper.getSubjectById(subjectId);
        return subject;
    }
}
