package com.lys.model;

public class CartVO {
	
	//memberVO + BookVO + CartVO (조인)
	//cart테이블의 필드명
	private int cart_id; //카트 번호
	
	private String writer; //로그인 한 ID
	
	private int bookno; //상품 번호
	
	private int amount; //수량
	
	//cartlist에 적용 될 필드명
	private String b_title; //상품 이름
	
	private String b_thumbnail; // 책 썸네일 이미지
	
	private int delivery; //배송비
	
	private int b_price;//상품 단가

	private int money; //상품 총 금액
	
	private int allSum; //카트 전체 금액(배송비 + 상품 가격)
	
	private int sumMoney; //카트 전체 금액(상품 금액)
	
	//getter / setter
	public int getAllSum() {
		return allSum;
	}

	public void setAllSum(int allSum) {
		this.allSum = allSum;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_thumbnail() {
		return b_thumbnail;
	}

	public void setB_thumbnail(String b_thumbnail) {
		this.b_thumbnail = b_thumbnail;
	}

	public int getDelivery() {
		return delivery;
	}

	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}

	public int getB_price() {
		return b_price;
	}

	public void setB_price(int b_price) {
		this.b_price = b_price;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(int sumMoney) {
		this.sumMoney = sumMoney;
	}

	@Override
	public String toString() {
		return "CartVO [cart_id=" + cart_id + ", writer=" + writer + ", bookno=" + bookno + ", amount=" + amount
				+ ", b_title=" + b_title + ", b_thumbnail=" + b_thumbnail + ", delivery=" + delivery + ", b_price="
				+ b_price + ", money=" + money + ", allSum=" + allSum + ", sumMoney=" + sumMoney + "]";
	}

}
