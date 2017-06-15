package com.site.mapper.auth;

import org.springframework.stereotype.Repository;

import com.site.common.framework.mybatis.mapper.BaseMapper;
import com.site.entity.auth.RolePermission;

/**
 * 角色菜单许可Mapper
 */
@Repository
public interface RolePermissionMapper extends BaseMapper<String, RolePermission> {

    public RolePermission findRolePermission(RolePermission per);

}
