package com.lys.model;

public class Book_OrderDetailsVO {
	
	//주문 상세 번호(주문 한 상품 번호)
	private int orderDetailsNum;
	//주문 번호
	private String orderid;
	//주문한 책 번호
	private int bookno;
	//주문한 상품 수량
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
