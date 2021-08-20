package kr.co.ss.member.domain;


/**
 * 아이디 찾기에 성공했을 때 제공할 데이터를 저장하는 VO
 * @author sist
 */
public class  IdFindDomain{
	private String member_id, member_name;
	private String member_sign_Date;
	
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
	public String getMember_sign_Date() {
		return member_sign_Date;
	}
	public void setMember_sign_Date(String member_sign_Date) {
		this.member_sign_Date = member_sign_Date;
	}
	
	

	

	
	
	
}//class
