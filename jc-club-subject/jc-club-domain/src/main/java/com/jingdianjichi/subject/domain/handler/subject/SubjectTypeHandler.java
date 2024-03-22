package com.jingdianjichi.subject.domain.handler.subject;

import com.jingdianjichi.subject.common.enums.SubjectInfoTypeEnum;
import com.jingdianjichi.subject.domain.entity.SubjectInfoBO;

/**
 * @Author:zxp
 * @Description:
 * @Date:11:03 2024/3/22
 */
public interface SubjectTypeHandler {
    /**
     * 获取题目类型
     * @return
     */
    SubjectInfoTypeEnum getHandlerType();
    /**
     * 真正的新增题目的地方
     */
    void add(SubjectInfoBO subjectInfoBO);

}
