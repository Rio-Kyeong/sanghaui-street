package kr.co.ss.member.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 아이디 찾기에 성공했을 때 제공할 데이터를 저장하는 VO
 * @author sist
 */
@Getter
@Setter
public class  IdFindDomain{
	private String member_id, member_name;
	private String member_sign_Date;
}