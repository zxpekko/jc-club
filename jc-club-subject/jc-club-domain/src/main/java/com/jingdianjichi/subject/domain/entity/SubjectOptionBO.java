package com.jingdianjichi.subject.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:17:22 2024/3/22
 */
@Data
public class SubjectOptionBO implements Serializable {
    private static final long serialVersionUID = -149315628227215316L;
    private String subjectAnswer;
    private List<SubjectAnswerBO> optionList;
}
