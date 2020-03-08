package com.lys.model;

public class OrderListDetailVO {

	//주문 번호
	private String orderid;
	//로그인
	private String userid;
	//주문 한 사람
	private String ordersend;
	//수령인
	private String orderrec;
	//수령 하고자 하는 우편 주소
	private String o_address_post;
	//수령 하고자 하는 도로명 주소
	private String o_address_road;
	//수령 하고자 하는 상세 주소
	private String o_address_detail;
	//주문 한 사람 연락처
	private String o_phone;
	//수령인 연락처
	private String r_phone;
	//배송물 위탁 할 장소
	private String place;
	//결제 방법
	private String pay;
	//결제 총 금액
	private int o_amount;
	//상품 이름
	private String b_title;
	//상품 단가
	private int b_price;
	//상품 이미지
	private String b_thumbnail;
	//상품 총 수량
	private int amount;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
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
	public int getO_amount() {
		return o_amount;
	}
	public void setO_amount(int o_amount) {
		this.o_amount = o_amount;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public int getB_price() {
		return b_price;
	}
	public void setB_price(int b_price) {
		this.b_price = b_price;
	}
	public String getB_thumbnail() {
		return b_thumbnail;
	}
	public void setB_thumbnail(String b_thumbnail) {
		this.b_thumbnail = b_thumbnail;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "OrderListDetailVO [orderid=" + orderid + ", userid=" + userid + ", ordersend=" + ordersend
				+ ", orderrec=" + orderrec + ", o_address_post=" + o_address_post + ", o_address_road=" + o_address_road
				+ ", o_address_detail=" + o_address_detail + ", o_phone=" + o_phone + ", r_phone=" + r_phone
				+ ", place=" + place + ", pay=" + pay + ", o_amount=" + o_amount + ", b_title=" + b_title + ", b_price="
				+ b_price + ", b_thumbnail=" + b_thumbnail + ", amount=" + amount + "]";
	}
	
}
