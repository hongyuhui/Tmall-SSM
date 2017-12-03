package com.pan.tmall.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	// 配置DispatcherServlet
	// 加载包含Web组件的bean，如控制器，视图解析器以及处理器映射
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	// 配置ContextLoaderListener
	// 加载应用的其他bean，通常是驱动应用后端的中间层和数据层组件
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootConfig.class };
	}

	// 配置映射路径
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	// 配置multipart
	@Override
	protected void customizeRegistration(Dynamic registration) {
		// 设置临时路径
		MultipartConfigElement element = new MultipartConfigElement("temp/uploads");
		registration.setMultipartConfig(element);
	}

	// 配置filter
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("utf-8", true, true);
		return new Filter[] { characterEncodingFilter };
	}
	
}
