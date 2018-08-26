package com.xc.mybook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
@MapperScan(value = {"com.xc.mybook.security.dao","com.xc.mybook.Mapper"})
public class MybookApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MybookApplication.class);
	}


	public static void main(String[] args) {
		
		SpringApplication.run(MybookApplication.class, args);
	}


}
