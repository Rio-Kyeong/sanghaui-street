package kr.co.ss.member.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * ������ �α��� �� �ʿ��� ������ �����ϴ� VO
 * @author sist
 */
@EqualsAndHashCode
@Getter
@Setter
public class AdminLoginVO {
	private String admin_id;
	private String admin_pw;
}//class
