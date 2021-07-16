package kr.co.ss.member.dao;

import org.apache.ibatis.session.SqlSession;
import kr.co.ss.connection.MyBatisHandler;
import kr.co.ss.member.domain.AdminLoginInfoDomain;
import kr.co.ss.member.domain.IdFindDomain;
import kr.co.ss.member.domain.LoginInfoDomain;
import kr.co.ss.member.domain.MemberSearchDomain;
import kr.co.ss.member.vo.AdminLoginVO;
import kr.co.ss.member.vo.LoginVO;
import kr.co.ss.member.vo.MemberUpdateVO;
import kr.co.ss.member.vo.MemberVO;
import kr.co.ss.member.vo.PasswordUpdateVO;
import kr.co.ss.member.vo.SearchIdVO;
import kr.co.ss.member.vo.SearchPwVO;


public class MemberDAO {
	
	
	/**
	 * 회원가입
	 * @param mVO
	 * @return
	 */
	public int insertMember(MemberVO mVO) {
		int rowCnt = 0;
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		
		rowCnt = ss.insert("kr.co.ss.member.memberMapper.insertMember", mVO);
		if(rowCnt == 1) {
			ss.commit();
		}
		
		if(ss != null ) { ss.close(); }
		
		return rowCnt;
	}
	
	/**
	 * 로그인
	 * @param lVO
	 * @return
	 */
	public LoginInfoDomain selectLogin(LoginVO lVO) {
		
		LoginInfoDomain lid = null;
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		
		lid = ss.selectOne("kr.co.ss.member.memberMapper.selectLogin", lVO);
		
		if(ss != null ) { ss.close(); }
		
		return lid;
	}
	
	/**
	 * 관리자 로그인
	 * @param alVO
	 * @return
	 */
	public AdminLoginInfoDomain selectAdminLogin(AdminLoginVO alVO) {
		
		AdminLoginInfoDomain alid = null;
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		
		alid = ss.selectOne("kr.co.ss.member.memberMapper.selectAdminLogin", alVO);
		
		if(ss != null ) { ss.close(); }
		
		return alid;
	}
	
	
	
	/**
	 * 마이페이지(정보 조회)
	 * @param id
	 * @return
	 */
	public MemberSearchDomain selectMemberInfo(String id){
		MemberSearchDomain msd = new MemberSearchDomain();
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		
		msd = ss.selectOne("kr.co.ss.member.memberMapper.selectMemberInfo", id);
		
		if(ss != null ) { ss.close(); }
		
		return msd;
	}
	
	/**
	 * 비밀번호 변경
	 * @param puVO
	 * @return
	 */
	public int updatePassword(PasswordUpdateVO puVO) {
		int cnt =0;
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		
		cnt = ss.update("kr.co.ss.member.memberMapper.updatePassword", puVO);
		if(cnt == 1 ) {
			ss.commit();
		}
		
		if(ss != null ) { ss.close(); }
		
		return cnt;
	}
	
	/**
	 * 회원탈퇴
	 * @param puVO
	 * @return
	 */
	public int deleteMember(String member_id) {
		int cnt =0;
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		
		cnt = ss.update("kr.co.ss.member.memberMapper.deleteMember", member_id);
		
		if(cnt == 1 ) {
			ss.commit();
		}
		
		if(ss != null ) { ss.close(); }
		
		return cnt;
	}
	
	/**
	 * 아이디 중복확인
	 * @param idCk
	 * @return
	 */
	public String selectDupId(String idCk){
		String member_id = "";
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		
		member_id = ss.selectOne("kr.co.ss.member.memberMapper.selectDupId", idCk);
		
		if(ss != null ) { ss.close(); }
		
		return member_id;	
	}
	
	/**
	 * 아이디 찾기
	 * @param sIVO
	 * @return
	 */
	public IdFindDomain selectSearchId(SearchIdVO sIVO) {
		IdFindDomain ifd = new IdFindDomain();
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		
		ifd = ss.selectOne("kr.co.ss.member.memberMapper.selectSearchId", sIVO);
		
		return ifd;
	}
	
	/**
	 * 비밀번호 찾기
	 * @param sVO
	 * @return
	 */
	public String selectSearchPw(SearchPwVO sVO) {
		String pass = "";
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		
		pass = ss.selectOne("kr.co.ss.member.memberMapper.selectSearchPw", sVO);
		
		return pass;
	}
	
	/**
	 * 회원정보 수정
	 * @param muVO
	 * @return
	 */
	public int updateMember(MemberUpdateVO muVO) {
		int cnt = 0;
		
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		
		cnt = ss.update("kr.co.ss.member.memberMapper.updateMember", muVO);
		
		if(cnt == 1 ) {
			ss.commit();
		}
		
		return cnt;
	}

}
