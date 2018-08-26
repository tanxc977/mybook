package com.xc.mybook.security.dao;

import com.xc.mybook.security.entity.TwPermission;
import com.xc.mybook.security.entity.TwRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionDao {

	/**
	 * 功能描述：获得操作权限
	 * CHENY037 2017年11月27日
	 * @param employeeId
	 * @return
	 */
	List<TwPermission> getPermissionByEmployeeId(String employeeId);

	/**
	 * 功能描述：获得角色
	 * CHENY037 2017年11月27日
	 * @param employeeId
	 * @return
	 */
	List<TwRole> getRoleByEmployeeId(String employeeId);
}
