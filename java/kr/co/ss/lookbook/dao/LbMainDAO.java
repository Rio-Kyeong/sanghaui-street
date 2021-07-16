package kr.co.ss.lookbook.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.ss.connection.MyBatisHandler;
import kr.co.ss.lookbook.domain.LbMainAllDomain;

public class LbMainDAO {
	
	
	public List<LbMainAllDomain> selectLookbookMainAll() {
		List<LbMainAllDomain>  lmadList= null;
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		lmadList = ss.selectList("kr.co.ss.lookbook.lookbookMainMapper.selectLbMainAll");
		
		if( ss != null) { ss.close();}
		return lmadList;
		
		
	}
	
	public List<LbMainAllDomain> selectLookbookMyMainAll(String member_id) {
		List<LbMainAllDomain>  lmadList= null;
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		lmadList = ss.selectList("kr.co.ss.lookbook.lookbookMainMapper.selectLbMyMainAll",member_id);
		
		if( ss != null) { ss.close();}
		return lmadList;
		
	}
	
	public List<String> selectLbMainImg(int lb_posts_num) {
		List<String> imgList = null;
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		imgList = ss.selectList("kr.co.ss.lookbook.lookbookMainMapper.selectLbMainImg",lb_posts_num);
		
		if( ss != null) { ss.close();}
		return imgList;
		
	}
}
