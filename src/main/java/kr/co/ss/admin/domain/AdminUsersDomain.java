package kr.co.ss.admin.domain;

import java.util.Date;

/**
 * 관리자가 보는 회원정보 리스트를 저장하는 클래스
 * @author sist
 */
public class AdminUsersDomain {
	private String member_id;
	private String member_name;
	private String member_gender;
	private String member_sign_date;
	private String member_withdrawal;
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_gender() {
		return member_gender;
	}
	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}
	
	public String getMember_sign_date() {
		return member_sign_date;
	}
	public void setMember_sign_date(String member_sign_date) {
		this.member_sign_date = member_sign_date;
	}
	public String getMember_withdrawal() {
		return member_withdrawal;
	}
	public void setMember_withdrawal(String member_withdrawal) {
		this.member_withdrawal = member_withdrawal;
	}
	

	
	
}//class
