package com.jingdianjichi.subject.domain.service;

import com.jingdianjichi.subject.domain.entity.SubjectCategoryBO;
import com.jingdianjichi.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:10:18 2024/3/20
 */
public interface SubjectCategoryDomainService {
    void add(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> queryPrimaryCategory();

    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    Boolean update(SubjectCategoryBO subjectCategoryBO);

    Boolean deleteById(SubjectCategoryBO subjectCategoryBO);
}
