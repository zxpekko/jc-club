package com.jingdianjichi.auth.infra.basic.service;

import com.jingdianjichi.auth.infra.basic.entity.AuthPermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (AuthPermission)表服务接口
 *
 * @author makejava
 * @since 2024-03-27 15:51:22
 */
public interface AuthPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthPermission queryById(Long id);

    /**
     * 分页查询
     *
     * @param authPermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    Page<AuthPermission> queryByPage(AuthPermission authPermission, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    Integer insert(AuthPermission authPermission);

    /**
     * 修改数据
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    Integer update(AuthPermission authPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    List<AuthPermission> queryByRoleList(List<Long> permissionIdList);
}
