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
	
	//ȸ������
	public int insertMember(MemberVO mVO);
	
	//�α���
	public LoginInfoDomain selectLogin(LoginVO lVO);
	
	//������ �α���
	public AdminLoginInfoDomain selectAdminLogin(AdminLoginVO alVO);
	
	//���� ������ ���� ��ȸ
	public MemberSearchDomain selectMemberInfo(String id);
	
	//��й�ȣ ����
	public int updatePassword(PasswordUpdateVO puVO);
	
	//ȸ��Ż��
	public int deleteMember(String member_id);
	
	//���̵� �ߺ�Ȯ��
	public String selectDupId(String idCk);
	
	//���̵� ã��
	public IdFindDomain selectSearchId(SearchIdVO sIVO);
	
	//��й�ȣ ã��
	public String selectSearchPw(SearchPwVO sVO);
	
	//ȸ������ ����
	public int updateMember(MemberUpdateVO muVO);
}
