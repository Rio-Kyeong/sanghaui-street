package kr.co.ss.lookbook.service;


import java.util.List;

import kr.co.ss.lookbook.dao.LbDetailDAO;
import kr.co.ss.lookbook.domain.LbCommentDomain;
import kr.co.ss.lookbook.domain.LbDetailDomain;
import kr.co.ss.lookbook.vo.InsertCommentVO;
import kr.co.ss.lookbook.vo.UpdateLbVO;

public class LbDetailService {

	public LbDetailDomain searchLbDetail(int lb_posts_num) {
		LbDetailDAO ldDAO = new LbDetailDAO();
		
		return ldDAO.selectLbDetail(lb_posts_num);
	}//searchLbDetail
	
	public List<LbCommentDomain> searchLbComments(int lb_posts_num){
		LbDetailDAO ldDAO = new LbDetailDAO();
		
		return ldDAO.selectLbComment(lb_posts_num);
	}//searchLbComments
	
	
	public int addComment(InsertCommentVO icVO) {
		
		LbDetailDAO ldDAO = new LbDetailDAO();
		
		return ldDAO.insertComment(icVO);
	}
	
	public void removeComment(int lb_posts_num) {
		
		LbDetailDAO ldDAO = new LbDetailDAO();
		ldDAO.deleteComment(lb_posts_num);
		
	}
	
	public void removeLb(int lb_posts_num) {
		
		LbDetailDAO ldDAO = new LbDetailDAO();
		ldDAO.deleteLb(lb_posts_num);
		
	}
	public void removeImgLb(int lb_posts_num) {
		
		LbDetailDAO ldDAO = new LbDetailDAO();
		ldDAO.deletImgeLb(lb_posts_num);
		
	}

	

	public void removeDetailComment(int lb_comments_num) {
		
		LbDetailDAO ldDAO = new LbDetailDAO();
		ldDAO.deleteDetailComment(lb_comments_num);
		
	}
	
	public void modifyLb(UpdateLbVO ulVO) {
		LbDetailDAO ldDAO = new LbDetailDAO();
		ldDAO.updateLb(ulVO);
	}
}//class
	

