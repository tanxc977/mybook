package com.xc.auth.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionRoleMapper {
    int getPerminsionByRoleId(int roleid);
}
