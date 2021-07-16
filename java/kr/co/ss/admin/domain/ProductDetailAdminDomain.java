package kr.co.ss.admin.domain;

import java.util.List;

/**
 * 관리자가 보는 상세 상품정보를 저장하는 클래스
 * @author sist
 */
public class ProductDetailAdminDomain {
	private int prod_num;
	private String prod_name;
	private String prod_price;
	private String prod_cat;
	private String prod_explain;
	private String prod_image;
	private String prod_add_date;
	private String prod_delete;
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_price() {
		return prod_price;
	}
	public void setProd_price(String prod_price) {
		this.prod_price = prod_price;
	}
	public String getProd_cat() {
		return prod_cat;
	}
	public void setProd_cat(String prod_cat) {
		this.prod_cat = prod_cat;
	}
	public String getProd_explain() {
		return prod_explain;
	}
	public void setProd_explain(String prod_explain) {
		this.prod_explain = prod_explain;
	}
	public String getProd_image() {
		return prod_image;
	}
	public void setProd_image(String prod_image) {
		this.prod_image = prod_image;
	}
	public String getProd_add_date() {
		return prod_add_date;
	}
	public void setProd_add_date(String prod_add_date) {
		this.prod_add_date = prod_add_date;
	}
	public String getProd_delete() {
		return prod_delete;
	}
	public void setProd_delete(String prod_delete) {
		this.prod_delete = prod_delete;
	}
	





	
	
}//class
