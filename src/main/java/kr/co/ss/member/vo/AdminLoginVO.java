package kr.co.ss.member.vo;

/**
 * 관리자 로그인 시 필요한 정보를 저장하는 VO
 * @author sist
 */
public class AdminLoginVO {
	private String admin_id;
	private String admin_pw;
	
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_pw() {
		return admin_pw;
	}
	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}
	
	
	
}//class
