package kr.co.ss.member.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * ȸ������ ��ȸ Ŭ����
 * @author sist
 */
@Getter
@Setter
public class MemberSearchDomain {
	private String member_name;
	private String member_phone;
	private String member_email;
	private int member_zipcode;
	private String member_addr;
	private String member_detailed_addr; // MEMBER_DETAILED_ADDR
	private String member_gender;
	private String member_birth;
}//class
