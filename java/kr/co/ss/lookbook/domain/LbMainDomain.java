package kr.co.ss.lookbook.domain;

import java.util.List;

public class LbMainDomain {
	private int lb_posts_num;
	private String member_id, lb_title;
	private List<String> img;
	
	
	
	public LbMainDomain() {
		super();
	}
	public LbMainDomain(int lb_posts_num, String member_id, String lb_title, List<String> img) {
		super();
		this.lb_posts_num = lb_posts_num;
		this.member_id = member_id;
		this.lb_title = lb_title;
		this.img = img;
	}
	public int getLb_posts_num() {
		
		return lb_posts_num;
	}
	public void setLb_posts_num(int lb_posts_num) {
		this.lb_posts_num = lb_posts_num;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getLb_title() {
		return lb_title;
	}
	public void setLb_title(String lb_title) {
		this.lb_title = lb_title;
	}
	public List<String> getImg() {
		return img;
	}
	public void setImg(List<String> img) {
		this.img = img;
	}
	
	

	
}
