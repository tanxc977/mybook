package com.xc.mybook.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

	@RequestMapping("/401")
	public String html401(){
		return "error/401";
	}
	
	@RequestMapping("/403")
	public String html403(){
		return "error/403";
	}
	
	@RequestMapping("/404")
	public String html404(){
		return "error/404";
	}
}
