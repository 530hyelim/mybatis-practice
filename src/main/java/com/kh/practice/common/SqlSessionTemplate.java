package com.kh.practice.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
    // static 블럭을 사용하여 클래스 로딩시 sqlSessionFactory객체를 생성.
	// 생성방법은 이전 교안 혹은 MyBatis메뉴얼 참고.
    private static SqlSessionFactory sqlSessionFactory;
    static {
    	String resource = "/mybatis-config.xml";
    	try(InputStream input = Resources.getResourceAsStream(resource)) {
    		sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
	
    // SqlSession을 반환하는 메서드 작성
    public static SqlSession getSession() {
    	return sqlSessionFactory.openSession(false);
    }
}
