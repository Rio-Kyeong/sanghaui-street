package kr.co.ss.member.service;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Random;

import kr.co.sist.util.cipher.DataEncrypt;
import kr.co.ss.member.dao.MemberDAO;
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

public class MemberService {

	/**
	 * 회원가입
	 * @param mVO
	 * @return
	 */
	public int addMember(MemberVO mVO) {
		int cnt = 0;
		
		MemberDAO mDAO = new MemberDAO();
		
		try {
			mVO.setMember_pw(DataEncrypt.messageDigest("MD5", mVO.getMember_pw()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} 
		cnt = mDAO.insertMember(mVO);
		
		return cnt;
	}
	
	/**
	 * 로그인
	 * @param lVO
	 * @return
	 */
	public LoginInfoDomain searchLogin(LoginVO lVO) {
		LoginInfoDomain lid = null;
		
		MemberDAO mDAO = new MemberDAO();
		try {
			lVO.setMember_pw(DataEncrypt.messageDigest("MD5", lVO.getMember_pw()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		lid = mDAO.selectLogin(lVO);
		
		return lid;	
	}
	
	/**
	 * 관리자 로그인
	 * @param alVO
	 * @return
	 */
	public AdminLoginInfoDomain searchAdminLogin(AdminLoginVO alVO) {
		AdminLoginInfoDomain alid = null;
		
		MemberDAO mDAO = new MemberDAO();
		try {
			alVO.setAdmin_pw(DataEncrypt.messageDigest("MD5", alVO.getAdmin_pw()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		alid = mDAO.selectAdminLogin(alVO);
		
		return alid;	
	}
	
	/**
	 * 마이페이지(정보조회)
	 * @param id
	 * @return
	 */
	public MemberSearchDomain searchMemberInfo(String id){
		MemberSearchDomain msd = new MemberSearchDomain();
		
		MemberDAO mDAO = new MemberDAO();
		msd = mDAO.selectMemberInfo(id);
		
		return msd;
	}
	
	/**
	 * 비밀번호 변경
	 * @param puVO
	 * @return
	 */
	public int modifyPassword(PasswordUpdateVO puVO) {
		int cnt = 0;
		
		try {
			puVO.setMember_pw(DataEncrypt.messageDigest("MD5", puVO.getMember_pw()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		MemberDAO mDAO = new MemberDAO();
		cnt = mDAO.updatePassword(puVO);
		
		return cnt;
	}
	
	/**
	 * 회원탈퇴
	 * @param mdVO
	 * @return
	 */
	public int removeMember(String member_id) {
		int cnt = 0;
		
		MemberDAO mDAO = new MemberDAO();
		cnt = mDAO.deleteMember(member_id);
		
		return cnt;
	}
	
	/**
	 * 아이디 중복확인
	 * @param id
	 * @return
	 */
	public boolean searchIdDup(String idCk) {
		boolean dupFlag = true;
		String member_id = "";
		
		MemberDAO mDAO = new MemberDAO();
		member_id = mDAO.selectDupId(idCk);
		
		if(member_id == null) {
			dupFlag = false;
		}
		return dupFlag;	
	}
	
	/**
	 * 아이디 찾기
	 * @param sVO
	 * @return
	 */
	public IdFindDomain SearchId(SearchIdVO sIVO) {
		IdFindDomain ifd = new IdFindDomain();
		
		MemberDAO mDAO = new MemberDAO();
		ifd = mDAO.selectSearchId(sIVO);
		
		return ifd;
	}
	
	/**
	 *	비밀번호 찾기(랜덤 비밀번호에 넣을 boolean값 생성)
	 * @param sVO
	 * @return
	 */
	public boolean SearchPw(SearchPwVO sVO) {
		String pass = "";
		boolean passFlag = false;
		
		MemberDAO mDAO = new MemberDAO();
		pass = mDAO.selectSearchPw(sVO);
		
		if(pass != null) {
			passFlag = true;
		}
		return passFlag;
	}
	
	/**
	 * 랜덤비밀번호 생성
	 * @param passFlag
	 * @return
	 */
	public String addRandomPw(boolean passFlag){
		
		StringBuffer TempraryPW = new StringBuffer();
		
		if(passFlag == true) {
	
		Random random = new Random();
	
		String chars[] = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,0,1,2,3,4,5,6,7,8,9".split(",");
	
		for (int i = 0; i < 4; i++) {
	
			TempraryPW.append(chars[random.nextInt(chars.length)]);
			
			}
		}
		return TempraryPW.toString();
	}
	
	/**
	 * 회원정보 조회
	 * @param muVO
	 * @return
	 */
	public int modifyMember(MemberUpdateVO muVO) {
		
		int cnt = 0;
		MemberDAO mDAO = new MemberDAO();
		
		cnt = mDAO.updateMember(muVO);
		
		return cnt;
	}
}
