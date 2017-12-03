package com.pan.tmall.mapper;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pan.tmall.pojo.Category;


public class TestMapper {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryMapper categoryMapper = context.getBean(CategoryMapper.class);
		
/*		Reader reader = Resources.getResourceAsReader("MyBatis_config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);
		List<Category> categories = categoryMapper.list(Page);
		Iterator<Category> cs = categories.iterator();
		while(cs.hasNext()) {
			Category c = cs.next();
			System.out.println(c.getName());
		}*/
				
	}
}
