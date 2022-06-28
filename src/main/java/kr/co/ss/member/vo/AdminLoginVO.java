package kr.co.ss.member.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 관리자 로그인 시 필요한 정보를 저장하는 VO
 * @author sist
 */
@EqualsAndHashCode
@Getter
@Setter
public class AdminLoginVO {
	private String admin_id;
	private String admin_pw;
}//class
