package com.xc.mybook.service;

import com.xc.mybook.security.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public Object findUser() {

		return null;
	}

}