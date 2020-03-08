package com.lys.model;

public class ReviewVO {
	
	private int rno; //���� ��ȣ
	private int bookno; //å ��ǰ ��ȣ
	private String r_contents; //���� ����
	private String r_writer; //�α��� �� ���̵�	
	private String r_regdate; //���� �ۼ��� ��¥/�ð�
	
	//getter / setter ����
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
