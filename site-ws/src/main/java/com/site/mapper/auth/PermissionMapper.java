package com.site.mapper.auth;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.site.common.framework.mybatis.mapper.BaseMapper;
import com.site.entity.auth.Permission;

/**
 * 菜单许可Mapper
 *
 */
@Repository
public interface PermissionMapper extends BaseMapper<String, Permission> {

    /**
     * 查询用户所能访问的所有菜单
     *
     * @param userId
     *            用户
     * @return permissions 菜单
     */
    public List<Permission> findPermissionByUserId(String userId);

    /**
     * 根据菜单KEY查询菜单
     *
     * @param permissionKey
     *            菜单KEY
     * @return
     */
    public Permission findPermissionByParentId(String permissionKey);
}