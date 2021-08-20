package kr.co.ss.lookbook.vo;

public class FileUploadVO {

	private int lb_posts_num;
	private String img;
	
	

	public FileUploadVO(int lb_posts_num, String img) {
		super();
		this.lb_posts_num = lb_posts_num;
		this.img = img;
	}
	public int getLb_posts_num() {
		return lb_posts_num;
	}
	public void setLb_posts_num(int lb_posts_num) {
		this.lb_posts_num = lb_posts_num;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}


	
}
