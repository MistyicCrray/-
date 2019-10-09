package com.nursery_school.manager;

import java.io.IOException;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@Configuration
@SpringBootApplication  // 核心注解
public class App {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 允许上传的文件最大值
		factory.setMaxFileSize("20MB"); // KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("1000MB");
//		factory.setLocation("e:/data/upload/images");
		return factory.createMultipartConfig();
	}
}
