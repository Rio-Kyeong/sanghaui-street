package kr.co.ss.admin.domain;

/**
 * 관리자가 보는 특정 회원의 상세정보 클래스
 * @author sist
 */
public class AdminUserInfoDomain {
	private String member_id;
	private String member_name;
	private String member_gender;
	private String member_birth;
	private String member_phone;
	private String member_email;
	private int member_zipcode;
	private String member_detailed_addr;
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
	public String getMember_birth() {
		return member_birth;
	}
	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public int getMember_zipcode() {
		return member_zipcode;
	}
	public void setMember_zipcode(int member_zipcode) {
		this.member_zipcode = member_zipcode;
	}
	public String getMember_detailed_addr() {
		return member_detailed_addr;
	}
	public void setMember_detailed_addr(String member_detailed_addr) {
		this.member_detailed_addr = member_detailed_addr;
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
