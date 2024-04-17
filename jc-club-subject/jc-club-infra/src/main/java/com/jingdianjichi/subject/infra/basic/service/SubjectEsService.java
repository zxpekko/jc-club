package com.jingdianjichi.subject.infra.basic.service;

import com.jingdianjichi.subject.common.entity.PageResult;
import com.jingdianjichi.subject.infra.basic.entity.SubjectInfoEs;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:05 2024/4/14
 */
public interface SubjectEsService {

    boolean insert(SubjectInfoEs subjectInfoEs);

    PageResult<SubjectInfoEs> querySubjectList(SubjectInfoEs subjectInfoEs);
}
