package com.lys.model;

public class BoardVO {
	
	//�Խ��� 
	
	private int bno; //�Խ��� ��ȣ
	private String title; //�� ����
	private String contents; //�� ����
	private String writer; //�α��� �� ID
	private String write_date; //�۾��� �� ��¥/�ð�
	private int cnt; //��ȸ��
	
	//getter / setter
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	//�۾��� �Խ��ǿ��� �Է� �� �� Ȯ��
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", contents=" + contents + ", writer=" + writer
				+ ", write_date=" + write_date + ", cnt=" + cnt + "]";
	}
}
