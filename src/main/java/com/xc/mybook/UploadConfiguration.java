package com.xc.mybook;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * file upload configuration
 *
 */
@Configuration
public class UploadConfiguration {
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
