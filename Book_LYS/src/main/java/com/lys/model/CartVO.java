package com.lys.model;

public class CartVO {
	
	//memberVO + BookVO + CartVO (����)
	//cart���̺��� �ʵ��
	private int cart_id; //īƮ ��ȣ
	
	private String writer; //�α��� �� ID
	
	private int bookno; //��ǰ ��ȣ
	
	private int amount; //����
	
	//cartlist�� ���� �� �ʵ��
	private String b_title; //��ǰ �̸�
	
	private String b_thumbnail; // å ����� �̹���
	
	private int delivery; //��ۺ�
	
	private int b_price;//��ǰ �ܰ�

	private int money; //��ǰ �� �ݾ�
	
	private int allSum; //īƮ ��ü �ݾ�(��ۺ� + ��ǰ ����)
	
	private int sumMoney; //īƮ ��ü �ݾ�(��ǰ �ݾ�)
	
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
