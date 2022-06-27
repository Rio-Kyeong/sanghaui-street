package kr.co.ss.member.dao;

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

public interface MemberDAOImp {
	
	//회원가입
	public int insertMember(MemberVO mVO);
	
	//로그인
	public LoginInfoDomain selectLogin(LoginVO lVO);
	
	//관리자 로그인
	public AdminLoginInfoDomain selectAdminLogin(AdminLoginVO alVO);
	
	//마이 페이지 정보 조회
	public MemberSearchDomain selectMemberInfo(String id);
	
	//비밀번호 변경
	public int updatePassword(PasswordUpdateVO puVO);
	
	//회원탈퇴
	public int deleteMember(String member_id);
	
	//아이디 중복확인
	public String selectDupId(String idCk);
	
	//아이디 찾기
	public IdFindDomain selectSearchId(SearchIdVO sIVO);
	
	//비밀번호 찾기
	public String selectSearchPw(SearchPwVO sVO);
	
	//회원정보 수정
	public int updateMember(MemberUpdateVO muVO);
}
