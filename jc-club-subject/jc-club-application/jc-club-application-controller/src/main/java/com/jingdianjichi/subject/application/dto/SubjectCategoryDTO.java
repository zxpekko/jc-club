package com.jingdianjichi.subject.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 题目分类(SubjectCategory)实体类
 *
 * @author makejava
 * @since 2024-03-19 15:58:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectCategoryDTO implements Serializable {
    private static final long serialVersionUID = 444799139909738099L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 分类类型
     */
    private Integer categoryType;
    /**
     * 图标连接
     */
    private String imageUrl;
    /**
     * 父级id
     */
    private Long parentId;
}

