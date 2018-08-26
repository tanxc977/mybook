package com.xc.mybook.security.dao;

import com.xc.mybook.security.entity.TwUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
	/**
	 * 功能描述：根据用户id找到用户信息
	 * CHENY037 2017年11月27日
	 * @param employeeId
	 * @return
	 */
	TwUser findByEmployeeId(String employeeId);
}
