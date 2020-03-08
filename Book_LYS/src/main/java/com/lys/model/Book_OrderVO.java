package com.lys.model;

public class Book_OrderVO {
	
	//주문 번호
	private String orderid;
	//로그인 id
	private String userid;
	//송신자
	private String ordersend;
	//수신자
	private String orderrec;
	//주문한 상품 총 가격 합계
	private int o_amount;
	//우편번호(배송지)
	private String o_address_post;
	//도로명(배송지)
	private String o_address_road;
	//상세 주소(배송지)
	private String o_address_detail;
	//송신자 연락처
	private String o_phone;
	//수신자 연락처
	private String r_phone;
	//수신자 위탁 장소
	private String place;
	//결제 방법
	private String pay;
	
	//getter / setter
	public int getO_amount() {
		return o_amount;
	}
	public void setO_amount(int o_amount) {
		this.o_amount = o_amount;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOrdersend() {
		return ordersend;
	}
	public void setOrdersend(String ordersend) {
		this.ordersend = ordersend;
	}
	public String getOrderrec() {
		return orderrec;
	}
	public void setOrderrec(String orderrec) {
		this.orderrec = orderrec;
	}
	public String getO_address_post() {
		return o_address_post;
	}
	public void setO_address_post(String o_address_post) {
		this.o_address_post = o_address_post;
	}
	public String getO_address_road() {
		return o_address_road;
	}
	public void setO_address_road(String o_address_road) {
		this.o_address_road = o_address_road;
	}
	public String getO_address_detail() {
		return o_address_detail;
	}
	public void setO_address_detail(String o_address_detail) {
		this.o_address_detail = o_address_detail;
	}
	public String getO_phone() {
		return o_phone;
	}
	public void setO_phone(String o_phone) {
		this.o_phone = o_phone;
	}
	public String getR_phone() {
		return r_phone;
	}
	public void setR_phone(String r_phone) {
		this.r_phone = r_phone;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	
	@Override
	public String toString() {
		return "Book_OrderVO [orderid=" + orderid + ", userid=" + userid + ", ordersend=" + ordersend + ", orderrec="
				+ orderrec + ", o_amount=" + o_amount + ", o_address_post=" + o_address_post + ", o_address_road="
				+ o_address_road + ", o_address_detail=" + o_address_detail + ", o_phone=" + o_phone + ", r_phone="
				+ r_phone + ", place=" + place + ", pay=" + pay + "]";
	}
}
