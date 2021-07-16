package kr.co.ss.lookbook.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.ss.connection.MyBatisHandler;
import kr.co.ss.lookbook.vo.InsertUpdateLbVO;

public class LbDAO {
	
	
	public void insertPostNo() {
		int rowCnt = 0;
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		rowCnt = ss.insert("kr.co.ss.lookbook.lookbookMapper.insertLbNum");
		
		if(rowCnt == 1) {
			ss.commit();
		}
	
		if( ss != null) { ss.close();}
	}//insertPostNo
	
	public String selectPostNo() {
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		String num = ss.selectOne("kr.co.ss.lookbook.lookbookMapper.selectLbNum");
		
		
		return num;
		
	}//selectPostNo
	
	
	public int insertUpdateLb(InsertUpdateLbVO iulVO) {
		int cnt = 0;
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		cnt = ss.update("kr.co.ss.lookbook.lookbookMapper.insertUpdateLb",iulVO);
		
		if(cnt == 1) {
			ss.commit();
		}
		if( ss != null) { ss.close();}
		return cnt;
	}
	
	public int selectLbImgNoCnt(int num) {
		int cnt = 0;
		SqlSession ss= MyBatisHandler.getInstance().getHandler();
		cnt = ss.selectOne("kr.co.ss.lookbook.lookbookMapper.selectLbImgCnt",num);
		if( ss != null) { ss.close();}
		return cnt;
	}//selectLbImgNoCnt

	
	public void deleteLbImgNo(int num) {
		SqlSession ss= MyBatisHandler.getInstance().getHandler();
		 ss.delete("kr.co.ss.lookbook.lookbookMapper.deleteLbImgNum",num);
			 ss.commit();
		 
		 if( ss != null) { ss.close();}
	}//selectLbImgNoCnt
	
	public void deleteLbNo(int num) {
		SqlSession ss= MyBatisHandler.getInstance().getHandler();
		ss.delete("kr.co.ss.lookbook.lookbookMapper.deleteLbNum",num);
		ss.commit();
		
		if( ss != null) { ss.close();}
	}//selectLbImgNoCnt
	
	
	

}//class
