package kr.co.ss.lookbook.vo;


public class UpdateLbVO{
	private int lb_posts_num;
	private String member_id, lb_title, lb_contents;
	
	
	
	
	public UpdateLbVO() {
		super();
	}
	public UpdateLbVO(int lb_posts_num, String member_id, String lb_title, String lb_contents) {
		super();
		this.lb_posts_num = lb_posts_num;
		this.member_id = member_id;
		this.lb_title = lb_title;
		this.lb_contents = lb_contents;
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
	public String getLb_contents() {
		return lb_contents;
	}
	public void setLb_contents(String lb_contents) {
		this.lb_contents = lb_contents;
	}
	
	
	
	
	

	
}
