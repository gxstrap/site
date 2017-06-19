package com.site.mapper.master.auth;

import org.springframework.stereotype.Repository;

import com.site.entity.auth.UserRole;
import com.site.mapper.SqlMapper;

/**
 * 用户角色Mapper
 */
@Repository
public interface UserRoleMapper extends SqlMapper {

    void insert(UserRole ur);

}
