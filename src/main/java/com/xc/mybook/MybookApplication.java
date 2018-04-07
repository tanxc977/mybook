package com.xc.mybook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MybookApplication {

//	@RequestMapping("/")
//	public String home(){
//		return "hello home mybook !";
//	}

	public static void main(String[] args) {
		
		SpringApplication.run(MybookApplication.class, args);
	}
}
