package com.xc.auth.mapper;

import com.xc.auth.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    int addRole(SysRole role);
    List<SysRole> findAllRole();
}
