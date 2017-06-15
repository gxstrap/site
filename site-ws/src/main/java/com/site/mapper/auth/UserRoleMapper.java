package com.site.mapper.auth;

import org.springframework.stereotype.Repository;

import com.site.common.framework.mybatis.mapper.BaseMapper;
import com.site.entity.auth.UserRole;

/**
 * 用户角色Mapper
 */
@Repository
public interface UserRoleMapper extends BaseMapper<String, UserRole> {

}
