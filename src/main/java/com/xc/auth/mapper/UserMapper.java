package com.xc.auth.mapper;

import com.xc.auth.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int addUser(SysUser user);
    List<SysUser> findAll();
}
