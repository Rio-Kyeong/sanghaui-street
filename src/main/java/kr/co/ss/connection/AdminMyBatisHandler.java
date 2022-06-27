package kr.co.ss.connection;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AdminMyBatisHandler {
	private static AdminMyBatisHandler mbh;
	private static SqlSessionFactory ssf;
	
	public AdminMyBatisHandler() {
		
	}
	
	public static AdminMyBatisHandler getInstance() {
		if(mbh == null) {
			mbh = new AdminMyBatisHandler();
		}
		return mbh;
	}//getInstance
	
	private SqlSessionFactory getSessionFactory() {
		if(ssf == null) {
			try {
				Reader reader = Resources.getResourceAsReader("kr/co/ss/connection/mybatis-config-admin.xml");
				ssf = new SqlSessionFactoryBuilder().build(reader);
				if(reader != null) { reader.close(); };
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ssf;
	}//getSessionFactory
	
	public SqlSession getHandler() {
		SqlSession ss = getSessionFactory().openSession();
		return ss;
	}//getHandler
}//class
