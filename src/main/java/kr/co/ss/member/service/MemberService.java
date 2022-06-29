package kr.co.ss.member.service;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.util.cipher.DataEncrypt;
import kr.co.ss.member.dao.MemberDAOImp;
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

@Service
public class MemberService implements MemberServiceImp{
	
	// MemberDAO 인터페이스 의존
	private final MemberDAOImp mDAO;
	
	@Autowired
	public MemberService(MemberDAOImp mDAO) {
		this.mDAO = mDAO;
	}

	/**
	 * 회원가입
	 * @param mVO
	 * @return
	 */
	@Override
	public int addMember(MemberVO mVO) {
		int cnt = 0;
		
		try {
			String pw = DataEncrypt.messageDigest("MD5", mVO.getMember_pw());
			mVO.setMember_pw(pw);
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
	@Override
	public LoginInfoDomain searchLogin(LoginVO lVO) {
		LoginInfoDomain lid = null;
		
		try {
			String pw = DataEncrypt.messageDigest("MD5", lVO.getMember_pw());
			lVO.setMember_pw(pw);
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
	@Override
	public AdminLoginInfoDomain searchAdminLogin(AdminLoginVO alVO) {
		AdminLoginInfoDomain alid = null;
		
		try {
			String pw =  DataEncrypt.messageDigest("MD5", alVO.getAdmin_pw());
			alVO.setAdmin_pw(pw);
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
	@Override
	public MemberSearchDomain searchMemberInfo(String id){
		MemberSearchDomain msd = new MemberSearchDomain();
		
		msd = mDAO.selectMemberInfo(id);
		
		return msd;
	}
	
	/**
	 * 비밀번호 변경
	 * @param puVO
	 * @return
	 */
	@Override
	public int modifyPassword(PasswordUpdateVO puVO) {
		int cnt = 0;
		
		try {
			String pw = DataEncrypt.messageDigest("MD5", puVO.getMember_pw());
			puVO.setMember_pw(pw);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		cnt = mDAO.updatePassword(puVO);
		
		return cnt;
	}
	
	/**
	 * 회원탈퇴
	 * @param mdVO
	 * @return
	 */
	@Override
	public int removeMember(String member_id) {
		int cnt = 0;

		cnt = mDAO.deleteMember(member_id);
		
		return cnt;
	}
	
	/**
	 * 아이디 중복확인
	 * @param id
	 * @return
	 */
	@Override
	public boolean searchIdDup(String idCk) {
		boolean dupFlag = true;
		String member_id = "";

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
	@Override
	public IdFindDomain SearchId(SearchIdVO sIVO) {
		IdFindDomain ifd = new IdFindDomain();

		ifd = mDAO.selectSearchId(sIVO);
		
		return ifd;
	}
	
	/**
	 * 비밀번호 찾기(랜덤 비밀번호에 넣을 boolean값 생성)
	 * @param sVO
	 * @return
	 */
	@Override
	public String SearchPw(SearchPwVO sVO) {
		
		String pass = mDAO.selectSearchPw(sVO);
		
		if(!pass.isEmpty()) { // 비밀번호 존재
			
			String RandomPass = addRandomPw(); // 랜덤 비밀번호 생성
			
			// 회원정보(이름,이메일)저장 POJO Class
			SearchIdVO sIVO = new SearchIdVO();
	
			sIVO.setMember_name(sVO.getMember_name());
			sIVO.setMember_email(sVO.getMember_email());
			
			// 아이디 찾기
			IdFindDomain ifd = SearchId(sIVO);
			
			// 회원정보(아이디, 비밀번호)변경 POJO Class
			PasswordUpdateVO puVO = new PasswordUpdateVO();
			
			puVO.setMember_id(ifd.getMember_id());
			puVO.setMember_pw(RandomPass);
			
			// 비밀변호 변경
			modifyPassword(puVO);
			
			return RandomPass;
		}
		return null;
	}
	
	/**
	 * 랜덤비밀번호 생성 유틸 메서드
	 * @param passFlag
	 * @return
	 */
	public String addRandomPw(){
		
		StringBuffer TempraryPW = new StringBuffer();
		
		Random random = new Random();
		String chars[] = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,0,1,2,3,4,5,6,7,8,9".split(",");

		for (int i = 0; i < 4; i++) {
			TempraryPW.append(chars[random.nextInt(chars.length)]);
			}
		
		return TempraryPW.toString();
	}
	
	/**
	 * 회원정보 조회
	 * @param muVO
	 * @return
	 */
	@Override
	public int modifyMember(MemberUpdateVO muVO) {
		
		int cnt = mDAO.updateMember(muVO);
		
		return cnt;
	}
}
