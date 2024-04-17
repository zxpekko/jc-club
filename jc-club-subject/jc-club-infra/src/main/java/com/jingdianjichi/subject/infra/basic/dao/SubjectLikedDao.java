package com.jingdianjichi.subject.infra.basic.dao;

import com.jingdianjichi.subject.infra.basic.entity.SubjectLiked;
import org.apache.ibatis.annotations.Param;
//import org.springframework.data.domain.Pageable;
import java.awt.print.Pageable;
import java.util.List;

/**
 * (SubjectLiked)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-15 13:30:48
 */
public interface SubjectLikedDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectLiked queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param subjectLiked 查询条件
//     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SubjectLiked> queryAllByLimit(SubjectLiked subjectLiked);

    /**
     * 统计总行数
     *
     * @param subjectLiked 查询条件
     * @return 总行数
     */
    long count(SubjectLiked subjectLiked);

    /**
     * 新增数据
     *
     * @param subjectLiked 实例对象
     * @return 影响行数
     */
    int insert(SubjectLiked subjectLiked);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SubjectLiked> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SubjectLiked> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SubjectLiked> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SubjectLiked> entities);
    int batchInsertOrUpdate(@Param("entities") List<SubjectLiked> entities);

    /**
     * 修改数据
     *
     * @param subjectLiked 实例对象
     * @return 影响行数
     */
    int update(SubjectLiked subjectLiked);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);
    List<SubjectLiked> queryPage(@Param("entity") SubjectLiked subjectLiked,
                                 @Param("start") int start,
                                 @Param("pageSize") Integer pageSize);

}

