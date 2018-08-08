package com.xc.mybook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.MultipartConfigElement;

@RestController
@SpringBootApplication
@Configuration
@MapperScan(value = {"com.xc.auth.mapper","com.xc.mybook.Mapper"})
public class MybookApplication {

//	@RequestMapping("/")
//	public String home(){
//		return "hello home mybook !";
//	}

	public static void main(String[] args) {
		
		SpringApplication.run(MybookApplication.class, args);
	}

	/**
	 * 文件上传配置
	 *
	 * @return
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//  单个数据大小
		factory.setMaxFileSize("200MB"); // KB,MB
		/// 总上传数据大小
		factory.setMaxRequestSize("200MB");
		return factory.createMultipartConfig();
	}

}
