package com.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
		 // Blog mapper = session.getMapper(Blog.class);
		 // Blog blog = mapper.selectBlog(101);
		  
		  //Blog blog = session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
		  List<Blog> list = session.selectList("com.test.mapper.selectBlog");
		  
		  
		  System.out.println(list.size());
		  
		} finally {
		  session.close();
		}
				

	}

}
