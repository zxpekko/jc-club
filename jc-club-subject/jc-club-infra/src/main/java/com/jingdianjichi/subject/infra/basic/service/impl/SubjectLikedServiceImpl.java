package com.jingdianjichi.subject.infra.basic.service.impl;

import com.jingdianjichi.subject.infra.basic.entity.SubjectLiked;
import com.jingdianjichi.subject.infra.basic.dao.SubjectLikedDao;
import com.jingdianjichi.subject.infra.basic.service.SubjectLikedService;
import org.springframework.stereotype.Service;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.awt.font.TextHitInfo;
import java.util.List;

/**
 * (SubjectLiked)表服务实现类
 *
 * @author makejava
 * @since 2024-04-15 13:30:48
 */
@Service("subjectLikedService")
public class SubjectLikedServiceImpl implements SubjectLikedService {
    @Resource
    private SubjectLikedDao subjectLikedDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectLiked queryById(Long id) {
        return this.subjectLikedDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param subjectLiked 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<SubjectLiked> queryByPage(SubjectLiked subjectLiked, PageRequest pageRequest) {
//        long total = this.subjectLikedDao.count(subjectLiked);
//        return new PageImpl<>(this.subjectLikedDao.queryAllByLimit(subjectLiked, pageRequest), pageRequest, total);
//    }

    /**
     * 新增数据
     *
     * @param subjectLiked 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectLiked insert(SubjectLiked subjectLiked) {
        this.subjectLikedDao.insert(subjectLiked);
        return subjectLiked;
    }

    /**
     * 修改数据
     *
     * @param subjectLiked 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectLiked update(SubjectLiked subjectLiked) {
        this.subjectLikedDao.update(subjectLiked);
        return this.queryById(subjectLiked.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectLikedDao.deleteById(id) > 0;
    }

    @Override
    public void batchInsertOrUpdate(List<SubjectLiked> subjectLikedList) {
        this.subjectLikedDao.batchInsertOrUpdate(subjectLikedList);
    }

    @Override
    public List<SubjectLiked> getSubjectLikedPage(SubjectLiked subjectLiked) {
        return this.subjectLikedDao.queryAllByLimit(subjectLiked);
    }

    @Override
    public int countByCondition(SubjectLiked subjectLiked) {
        return (int)this.subjectLikedDao.count(subjectLiked);
    }

    @Override
    public List<SubjectLiked> queryPage(SubjectLiked subjectLiked, int start, Integer pageSize) {
        return this.subjectLikedDao.queryPage(subjectLiked,start,pageSize);
    }
}
