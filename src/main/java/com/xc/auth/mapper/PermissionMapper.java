package com.xc.auth.mapper;

import java.security.Permission;
import java.util.List;


public interface PermissionMapper {
    public List<Permission> findAll();
    public List<Permission> findByAdminUserId(int userId );
}
