package kr.co.ss.admin.domain;

import java.sql.Clob;

/**
 * 관리자의 룩북 게시글 상세조회 클래스
 * @author sist
 */
public class AdminLBDetailDomain {
	private int lb_posts_num;
	private String lb_title;
	private String member_id;
	private String lb_contents;
	public int getLb_posts_num() {
		return lb_posts_num;
	}
	public void setLb_posts_num(int lb_posts_num) {
		this.lb_posts_num = lb_posts_num;
	}
	public String getLb_title() {
		return lb_title;
	}
	public void setLb_title(String lb_title) {
		this.lb_title = lb_title;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getLb_contents() {
		return lb_contents;
	}
	public void setLb_contents(String lb_contents) {
		this.lb_contents = lb_contents;
	}
	
	


	
}//class
