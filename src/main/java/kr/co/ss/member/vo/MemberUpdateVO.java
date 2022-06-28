package kr.co.ss.member.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * ȸ�������� �����ϴµ� �ʿ��� ������ �����ϴ� Ŭ����
 * @author sist
 */
@EqualsAndHashCode
@Getter
public class MemberUpdateVO {
	private String member_id;
	private String member_name;
	private String member_phone;
	private String member_email;
	private int member_zipcode;
	private String member_addr;
	private String member_detailed_Addr;
	private String member_gender;
	private String member_birth;
}//class
