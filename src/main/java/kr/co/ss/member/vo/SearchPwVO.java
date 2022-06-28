package kr.co.ss.member.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 비밀번호를 찾는데 필요한 정보를 저장하는 클래스
 * @author sist
 */
@EqualsAndHashCode
@Getter
@Setter
public class SearchPwVO {
	private String member_id;
	private String member_name;
	private String member_email;
}//class
