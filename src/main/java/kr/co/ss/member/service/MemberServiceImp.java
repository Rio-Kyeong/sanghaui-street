package kr.co.ss.member.service;

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

public interface MemberServiceImp {
	
	//회원가입
	public int addMember(MemberVO mVO);
		
	//로그인
	public LoginInfoDomain searchLogin(LoginVO lVO);
		
	//관리자 로그인
	public AdminLoginInfoDomain searchAdminLogin(AdminLoginVO alVO);
	
	//마이 페이지(정보조회)
	public MemberSearchDomain searchMemberInfo(String id);
	
	//비밀번호 변경 
	public int modifyPassword(PasswordUpdateVO puVO);
	
	//회원 탈퇴
	public int removeMember(String member_id);
	
	//아이디 중복확인
	public boolean searchIdDup(String idCk);
	
	//아이디 찾기
	public IdFindDomain SearchId(SearchIdVO sIVO);
	
	//비밀번호 찾고 랜덤 비밀번호 생성
	public String SearchPw(SearchPwVO sVO);
	
	//회원정보 조회
	public int modifyMember(MemberUpdateVO muVO);
}
