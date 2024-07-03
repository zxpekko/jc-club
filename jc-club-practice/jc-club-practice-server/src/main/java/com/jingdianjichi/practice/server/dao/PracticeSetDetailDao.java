package com.jingdianjichi.practice.server.dao;

import com.jingdianjichi.practice.server.entity.po.PracticeSetDetailPO;

import java.util.List;

/**
 * @Author:zxp
 * @Description:
 * @Date:15:19 2024/6/3
 */
public interface PracticeSetDetailDao {
    void add(PracticeSetDetailPO detailPO);

    List<PracticeSetDetailPO> selectBySetId(Long setId);
}
