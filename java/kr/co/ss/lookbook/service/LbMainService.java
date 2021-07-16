package kr.co.ss.lookbook.service;

import java.util.List;

import kr.co.ss.lookbook.dao.LbMainDAO;
import kr.co.ss.lookbook.domain.LbMainAllDomain;

public class LbMainService {

	public List<LbMainAllDomain> searchLbMainAll() {
		LbMainDAO lmDAO = new LbMainDAO();
		
		return lmDAO.selectLookbookMainAll();
	}
	
	public List<LbMainAllDomain> searchLbMyMainAll(String member_id) {
		LbMainDAO lmDAO = new LbMainDAO();
		
		return lmDAO.selectLookbookMyMainAll(member_id);
	}
	
	public List<String> searchLbMainImg(int lb_posts_num){
		
		LbMainDAO lmDAO = new LbMainDAO();
		
		return lmDAO.selectLbMainImg(lb_posts_num);
	}
}
