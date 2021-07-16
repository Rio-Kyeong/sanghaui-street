package kr.co.ss.order.vo;

/**
 * 주문내역 INSERT
 * @author sist
 */
public class OrderInsertVO {
	
	private String member_id;
	private int prod_num;
	private String order_size;
	private String order_price;
	private int order_quantity;
	

	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	public String getOrder_size() {
		return order_size;
	}
	public void setOrder_size(String order_size) {
		this.order_size = order_size;
	}
	public String getOrder_price() {
		return order_price;
	}
	public void setOrder_price(String order_price) {
		this.order_price = order_price;
	}
	public int getOrder_quantity() {
		return order_quantity;
	}
	public void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}
	
	
	

}//class
