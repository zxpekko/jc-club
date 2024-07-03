package com.jingdianjichi.practice.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:41 2024/6/2
 */
@Data
public class SpecialPracticeVO implements Serializable {//一级分类

    private String primaryCategoryName;

    private Long primaryCategoryId;

    private List<SpecialPracticeCategoryVO> categoryList;//里面包着二级分类

}
