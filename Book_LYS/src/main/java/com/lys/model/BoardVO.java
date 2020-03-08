package com.lys.model;

public class BoardVO {
	
	//게시판 
	
	private int bno; //게시판 번호
	private String title; //글 제목
	private String contents; //글 내용
	private String writer; //로그인 된 ID
	private String write_date; //글쓰기 한 날짜/시간
	private int cnt; //조회수
	
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
	
	//글쓰기 게시판에서 입력 된 값 확인
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", contents=" + contents + ", writer=" + writer
				+ ", write_date=" + write_date + ", cnt=" + cnt + "]";
	}
}
