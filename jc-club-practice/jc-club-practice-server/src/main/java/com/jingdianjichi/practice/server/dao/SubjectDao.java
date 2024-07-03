package com.jingdianjichi.practice.server.dao;

import com.jingdianjichi.practice.server.entity.dto.PracticeSubjectDTO;
import com.jingdianjichi.practice.server.entity.po.SubjectPO;

import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:23 2024/6/3
 */
public interface SubjectDao {
    List<SubjectPO> getPracticeSubject(PracticeSubjectDTO dto);

    SubjectPO selectById(Long subjectId);
}
