package com.site.mapper.master.auth;

import org.springframework.stereotype.Repository;

import com.site.entity.auth.RolePermission;
import com.site.mapper.SqlMapper;

/**
 * 角色菜单许可Mapper
 */
@Repository
public interface RolePermissionMapper extends SqlMapper {

    public RolePermission findRolePermission(RolePermission per);

    public void insert(RolePermission rolePermission);

}
