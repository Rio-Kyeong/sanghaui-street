package kr.co.ss.member.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * ȸ������ �� �Է��ؾ��ϴ� ������ �����ϴ� Ŭ����
 * @author sist
 */

@EqualsAndHashCode
@Getter
@Setter
public class MemberVO {
	private int member_zipcode;
	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_addr;
	private String member_detailedAddr;
	private String member_phone;
	private String member_email;
	private String member_gender;
	private String member_birth;
}