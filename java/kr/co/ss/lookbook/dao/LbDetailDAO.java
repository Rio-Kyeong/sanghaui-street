package kr.co.ss.lookbook.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.ss.connection.MyBatisHandler;
import kr.co.ss.lookbook.domain.LbCommentDomain;
import kr.co.ss.lookbook.domain.LbDetailDomain;
import kr.co.ss.lookbook.vo.InsertCommentVO;
import kr.co.ss.lookbook.vo.UpdateLbVO;

public class LbDetailDAO {

	
	public LbDetailDomain selectLbDetail(int lb_posts_num) {
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		LbDetailDomain ldDomain = ss.selectOne("kr.co.ss.lookbook.lookbookDetailMapper.selectLbDetail",lb_posts_num);
		
		if( ss!= null) { ss.close(); }
		return ldDomain;
	}//selectLbDetail
	
	public List<LbCommentDomain> selectLbComment(int lb_posts_num) {
		List<LbCommentDomain> lcList = null;
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		lcList = ss.selectList("kr.co.ss.lookbook.lookbookDetailMapper.selectComment",lb_posts_num);
		
		if( ss!= null) { ss.close(); }
		return lcList;
	}//selectLbDetail
	
	
	public int insertComment(InsertCommentVO icVO) {
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		int cnt = ss.insert("kr.co.ss.lookbook.lookbookDetailMapper.insertComment",icVO);
		
		if(cnt == 1) {
			ss.commit();
		}
		
		if(ss!=null) {ss.close();}
		return cnt;
		
	}
	
	/**
	 * 게시글삭제버튼에서 댓글삭제
	 * @param lb_posts_num
	 */
	public void deleteComment(int lb_posts_num) {
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		ss.delete("kr.co.ss.lookbook.lookbookDetailMapper.deleteCommentLb",lb_posts_num);
		
			ss.commit();
		
		if(ss!=null) {ss.close();}
		
	}
	
	public void deleteLb(int lb_posts_num) {
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		ss.delete("kr.co.ss.lookbook.lookbookDetailMapper.deleteLb",lb_posts_num);
		
			ss.commit();
		
		if(ss!=null) {ss.close();}
		
	}
	public void deletImgeLb(int lb_posts_num) {
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		 ss.delete("kr.co.ss.lookbook.lookbookDetailMapper.deleteImgLb",lb_posts_num);
		ss.commit();
		
		if(ss!=null) {ss.close();}
		
		
	}


	
	public void deleteDetailComment(int lb_comment_num) {
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		ss.delete("kr.co.ss.lookbook.lookbookDetailMapper.deleteCommentDetail",lb_comment_num);
		
		ss.commit();
		
		if(ss!=null) {ss.close();}
		
	}
	
	public void updateLb(UpdateLbVO ulVO) {
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		ss.update("kr.co.ss.lookbook.lookbookDetailMapper.updateLb",ulVO);
		
			ss.commit();
		
		if(ss!=null) {ss.close();}
		
	}
}//class
