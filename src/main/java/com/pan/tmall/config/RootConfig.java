package com.pan.tmall.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.pan.tmall.pojo.SignOfPojo;
import com.pan.tmall.service.impl.SignOfServiceImpl;
import com.pan.tmall.util.SignOfUtil;

@Configuration
@ComponentScan(basePackageClasses = { SignOfServiceImpl.class, SignOfPojo.class, SignOfUtil.class }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
@ImportResource(locations = { "classpath:applicationContext.xml" })
public class RootConfig {

	@Bean
	public MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}

}
