package com.xc.auth.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleUserMapper {
    int getRoleByUserId(int userId);
}
