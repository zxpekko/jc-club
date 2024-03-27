package com.jingdianjichi.auth.infra.basic.service;

import com.jingdianjichi.auth.infra.basic.entity.AuthRole;

import java.util.List;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;

/**
 * (AuthRole)表服务接口
 *
 * @author makejava
 * @since 2024-03-27 14:15:29
 */
public interface AuthRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthRole queryById(Long id);

    /**
     * 分页查询
     *
     * @param authRole 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    Page<AuthRole> queryByPage(AuthRole authRole, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    Integer insert(AuthRole authRole);

    /**
     * 修改数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    Integer update(AuthRole authRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    List<AuthRole> queryByCondition(AuthRole authRole);
}
