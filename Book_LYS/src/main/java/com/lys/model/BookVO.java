package com.lys.model;

import org.springframework.web.multipart.MultipartFile;

public class BookVO {
	
	//(책)상품 등록 
	
	private String b_title; //책 제목
	private int b_price; //책 가격
	private String b_contents; //책 내용
	private String b_img; //책 원본 이미지
	private String b_thumbnail; // 책 썸네일 이미지
	private String b_regdate; // 등록 시간
	private int bookno; //책 등록 번호
	
	public String getB_thumbnail() {
		return b_thumbnail;
	}
	public void setB_thumbnail(String b_thumbnail) {
		this.b_thumbnail = b_thumbnail;
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
	public String getB_contents() {
		return b_contents;
	}
	public void setB_contents(String b_contents) {
		this.b_contents = b_contents;
	}
	public String getB_img() {
		return b_img;
	}
	public void setB_img(String b_img) {
		this.b_img = b_img;
	}
	public String getB_regdate() {
		return b_regdate;
	}
	public void setB_regdate(String b_regdate) {
		this.b_regdate = b_regdate;
	}
	public int getBookno() {
		return bookno;
	}
	public void setBookno(int bookno) {
		this.bookno = bookno;
	}
	
	@Override
	public String toString() {
		return "BookVO [b_title=" + b_title + ", b_price=" + b_price + ", b_contents=" + b_contents + ", b_img=" + b_img
				+ ", b_thumbnail=" + b_thumbnail + ", b_regdate=" + b_regdate + ", bookno=" + bookno + "]";
	}
	
	
	
}
