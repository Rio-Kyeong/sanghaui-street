package kr.co.ss.member.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 회원정보를 수정하는데 필요한 정보를 저장하는 클래스
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
