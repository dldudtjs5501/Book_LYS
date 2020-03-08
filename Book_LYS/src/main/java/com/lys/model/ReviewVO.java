package com.lys.model;

public class ReviewVO {
	
	private int rno; //리뷰 번호
	private int bookno; //책 상품 번호
	private String r_contents; //리뷰 내용
	private String r_writer; //로그인 한 아이디	
	private String r_regdate; //리뷰 작성한 날짜/시간
	
	//getter / setter 적용
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBookno() {
		return bookno;
	}
	public void setBookno(int bookno) {
		this.bookno = bookno;
	}
	public String getR_contents() {
		return r_contents;
	}
	public void setR_contents(String r_contents) {
		this.r_contents = r_contents;
	}
	public String getR_writer() {
		return r_writer;
	}
	public void setR_writer(String r_writer) {
		this.r_writer = r_writer;
	}
	
	public String getR_regdate() {
		return r_regdate;
	}
	public void setR_regdate(String r_regdate) {
		this.r_regdate = r_regdate;
	}
	
	@Override
	public String toString() {
		return "ReviewVO [rno=" + rno + ", bookno=" + bookno + ", r_contents=" + r_contents + ", r_writer=" + r_writer
				+ ", r_regdate=" + r_regdate + "]";
	}

}
