package com.lys.model;

public class Book_OrderDetailsVO {
	
	//�ֹ� �� ��ȣ(�ֹ� �� ��ǰ ��ȣ)
	private int orderDetailsNum;
	//�ֹ� ��ȣ
	private String orderid;
	//�ֹ��� å ��ȣ
	private int bookno;
	//�ֹ��� ��ǰ ����
	private int amount;
	
	//getter / setter
	public int getOrderDetailsNum() {
		return orderDetailsNum;
	}
	public void setOrderDetailsNum(int orderDetailsNum) {
		this.orderDetailsNum = orderDetailsNum;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public int getBookno() {
		return bookno;
	}
	public void setBookno(int bookno) {
		this.bookno = bookno;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "Book_OrderDetailsVO [orderDetailsNum=" + orderDetailsNum + ", orderid=" + orderid + ", bookno=" + bookno
				+ ", amount=" + amount + "]";
	}	
}
