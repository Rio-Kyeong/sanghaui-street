package kr.co.ss.lookbook.service;

import java.util.List;

import kr.co.ss.lookbook.dao.LbDAO;
import kr.co.ss.lookbook.vo.InsertUpdateLbVO;

public class LbService {

	
	public void addPostNo() {
		
		LbDAO ld = new LbDAO();
		ld.insertPostNo();
	}//addPostNo
	
	public String searchPostNo() {
		LbDAO ld = new LbDAO();
		String num = ld.selectPostNo();
		
		return num;
	}//addPostNo
	
	
	
	
	
	public int addModifyLb(InsertUpdateLbVO iulVO) {
		LbDAO ld = new LbDAO();
		
		return ld.insertUpdateLb(iulVO);
	}//addModifyLb
	
	
	public int searchLbImgNoCnt(int num) {
		
		LbDAO ld = new LbDAO();
		
		return ld.selectLbImgNoCnt(num);
	}//searchLbImgNoCnt
	
	public void removeLbImgNo(int num) {
		LbDAO ld = new LbDAO();
		ld.deleteLbImgNo(num);
	}
	
	public void removeLbNo(int num) {
		LbDAO ld = new LbDAO();
		 ld.deleteLbNo(num);
	}
}
