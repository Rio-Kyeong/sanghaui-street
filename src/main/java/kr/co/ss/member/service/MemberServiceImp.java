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
	
	//ȸ������
	public int addMember(MemberVO mVO);
		
	//�α���
	public LoginInfoDomain searchLogin(LoginVO lVO);
		
	//������ �α���
	public AdminLoginInfoDomain searchAdminLogin(AdminLoginVO alVO);
	
	//���� ������(������ȸ)
	public MemberSearchDomain searchMemberInfo(String id);
	
	//��й�ȣ ���� 
	public int modifyPassword(PasswordUpdateVO puVO);
	
	//ȸ�� Ż��
	public int removeMember(String member_id);
	
	//���̵� �ߺ�Ȯ��
	public boolean searchIdDup(String idCk);
	
	//���̵� ã��
	public IdFindDomain SearchId(SearchIdVO sIVO);
	
	//��й�ȣ ã�� ���� ��й�ȣ ����
	public String SearchPw(SearchPwVO sVO);
	
	//ȸ������ ��ȸ
	public int modifyMember(MemberUpdateVO muVO);
}
