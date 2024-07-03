package com.jingdianjichi.practice.server.dao;

//import com.jingdianjichi.practice.server.entity.po.SubjectLabelPO;
import com.jingdianjichi.practice.server.entity.po.SubjectLabelPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 题目标签表(SubjectLabel)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-03 21:50:29
 */
public interface SubjectLabelDao {


    SubjectLabelPO queryById(Long id);

    List<String> getLabelNameByIds(List<Long> labelIdList);
}

