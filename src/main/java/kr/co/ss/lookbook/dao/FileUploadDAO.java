package kr.co.ss.lookbook.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.ss.connection.MyBatisHandler;
import kr.co.ss.lookbook.vo.FileUploadVO;

public class FileUploadDAO {

	public int insertLbImg(FileUploadVO fuVO) {
		int cnt = 0;
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		cnt = ss.insert("kr.co.ss.lookbook.lookbookMapper.insertLbImg", fuVO);
		
		if(cnt == 1) {
			ss.commit();
		}
	
		if( ss != null) { ss.close();}
		return cnt;
	}//insertLbImg
}
