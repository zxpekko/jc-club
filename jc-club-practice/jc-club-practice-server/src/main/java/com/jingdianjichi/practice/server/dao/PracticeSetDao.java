package com.jingdianjichi.practice.server.dao;

import com.jingdianjichi.practice.server.entity.po.PracticeSetPO;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:18 2024/6/3
 */
public interface PracticeSetDao {
    void add(PracticeSetPO practiceSetPO);

    PracticeSetPO selectById(Long setId);

    void updateHeat(Long setId);
}
