package com.lys.model;

public class OrderListDetailVO {

	//�ֹ� ��ȣ
	private String orderid;
	//�α���
	private String userid;
	//�ֹ� �� ���
	private String ordersend;
	//������
	private String orderrec;
	//���� �ϰ��� �ϴ� ���� �ּ�
	private String o_address_post;
	//���� �ϰ��� �ϴ� ���θ� �ּ�
	private String o_address_road;
	//���� �ϰ��� �ϴ� �� �ּ�
	private String o_address_detail;
	//�ֹ� �� ��� ����ó
	private String o_phone;
	//������ ����ó
	private String r_phone;
	//��۹� ��Ź �� ���
	private String place;
	//���� ���
	private String pay;
	//���� �� �ݾ�
	private int o_amount;
	//��ǰ �̸�
	private String b_title;
	//��ǰ �ܰ�
	private int b_price;
	//��ǰ �̹���
	private String b_thumbnail;
	//��ǰ �� ����
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
