package com.jingdianjichi.subject.infra.basic.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jingdianjichi.subject.infra.basic.entity.SubjectRadio;

import java.util.List;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;

/**
 * 单选题信息表(SubjectRadio)表服务接口
 *
 * @author makejava
 * @since 2024-03-22 10:11:27
 */
public interface SubjectRadioService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectRadio queryById(Long id);

    /**
     * 分页查询
     *
     * @param subjectRadio 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    Page<SubjectRadio> queryByPage(SubjectRadio subjectRadio, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param subjectRadio 实例对象
     * @return 实例对象
     */
    SubjectRadio insert(SubjectRadio subjectRadio);

    /**
     * 修改数据
     *
     * @param subjectRadio 实例对象
     * @return 实例对象
     */
    SubjectRadio update(SubjectRadio subjectRadio);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    void batchInsert(List<SubjectRadio> subjectRadioList);

    List<SubjectRadio> queryByCondition(SubjectRadio subjectRadio);
}
