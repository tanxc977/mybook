package com.xc.mybook.security.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * 默认跳转页面配置
 * 
 * @author XC
 */
@Configuration
public class DeaultPageConfig {
	@Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        return new DeaultPage();
    }

    private static class DeaultPage implements EmbeddedServletContainerCustomizer {

        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
        	//映射配置在 com.tw.controller.DefaultCOntroller
            container.addErrorPages(
            		new ErrorPage(HttpStatus.UNAUTHORIZED, "/401"),
            		new ErrorPage(HttpStatus.FORBIDDEN, "/403"),
            		new ErrorPage(HttpStatus.NOT_FOUND, "/404")
            );
        }
    }
}
