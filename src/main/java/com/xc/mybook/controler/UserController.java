package com.xc.mybook.controler;

import com.xc.mybook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	/**
	 * 功能描述：新增用户
	 * CHENY037 2017年11月27日
	 * @param req
	 * @param res
	 */
	public void addUser(HttpServletRequest req,HttpServletResponse res){
		
	}
}
