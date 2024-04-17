package com.jingdianjichi.subject.infra.basic.service;

import com.jingdianjichi.subject.infra.basic.entity.SubjectLiked;

import java.util.List;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;

/**
 * (SubjectLiked)表服务接口
 *
 * @author makejava
 * @since 2024-04-15 13:30:48
 */
public interface SubjectLikedService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectLiked queryById(Long id);

    /**
     * 分页查询
     *
     * @param subjectLiked 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    Page<SubjectLiked> queryByPage(SubjectLiked subjectLiked, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param subjectLiked 实例对象
     * @return 实例对象
     */
    SubjectLiked insert(SubjectLiked subjectLiked);

    /**
     * 修改数据
     *
     * @param subjectLiked 实例对象
     * @return 实例对象
     */
    SubjectLiked update(SubjectLiked subjectLiked);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    void batchInsertOrUpdate(List<SubjectLiked> subjectLikedList);

    List<SubjectLiked> getSubjectLikedPage(SubjectLiked subjectLiked);

    int countByCondition(SubjectLiked subjectLiked);

    List<SubjectLiked> queryPage(SubjectLiked subjectLiked, int start, Integer pageSize);
}
