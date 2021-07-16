package kr.co.ss.lookbook.domain;

import java.sql.Date;

public class LbCommentDomain {

	private int lb_comments_num;
	private String member_id, lb_comments;
	private Date lb_comments_date;
	public int getLb_comments_num() {
		return lb_comments_num;
	}
	public void setLb_comments_num(int lb_comments_num) {
		this.lb_comments_num = lb_comments_num;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getLb_comments() {
		return lb_comments;
	}
	public void setLb_comments(String lb_comments) {
		this.lb_comments = lb_comments;
	}
	public Date getLb_comments_date() {
		return lb_comments_date;
	}
	public void setLb_comments_date(Date lb_comments_date) {
		this.lb_comments_date = lb_comments_date;
	}
	
	
	
	
	
}
