package com.xc.mybook.security.dao;

import com.xc.mybook.security.entity.TwRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleDao {
	List <TwRole> findRoleByEmployeeId(String employeeId);
}
