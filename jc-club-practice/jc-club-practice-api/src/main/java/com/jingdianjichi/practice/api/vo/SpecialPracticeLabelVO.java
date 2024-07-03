package com.jingdianjichi.practice.api.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:42 2024/6/2
 */
@Data
public class SpecialPracticeLabelVO implements Serializable {

    private Long id;//标签和分类是多对多，真的要开始根据标签查询的时候，需要知道标签属于哪个分类。

    /**
     * 分类id-标签ID
     */
    private String assembleId;

    private String labelName;

}
