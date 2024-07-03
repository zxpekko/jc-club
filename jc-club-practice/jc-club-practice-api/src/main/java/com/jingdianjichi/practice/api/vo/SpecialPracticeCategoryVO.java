package com.jingdianjichi.practice.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:13:42 2024/6/2
 */
@Data
public class SpecialPracticeCategoryVO implements Serializable {//二级分类

    private String categoryName;

    private Long categoryId;

    private List<SpecialPracticeLabelVO> labelList;//里面包着标签

}
