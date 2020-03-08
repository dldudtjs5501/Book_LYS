package com.lys.model;

public class Book_PageVO {
	
	//페이징의 시작번호
	private int b_startPage;
		
	//페이징의 끝번호
	private int b_endPage;
		
	//페이징의 이전
	private boolean b_prev;
		
	//페이징의 다음
	private boolean b_next;
		
	//전체 건수
	private int b_total;
		
	//Criteria - 1페이지당 총 list 건수(1page - 6)
	private Book_Criteria bcri;
	
	public int getB_startPage() {
		return b_startPage;
	}

	public void setB_startPage(int b_startPage) {
		this.b_startPage = b_startPage;
	}

	public int getB_endPage() {
		return b_endPage;
	}

	public void setB_endPage(int b_endPage) {
		this.b_endPage = b_endPage;
	}

	public boolean isB_prev() {
		return b_prev;
	}

	public void setB_prev(boolean b_prev) {
		this.b_prev = b_prev;
	}

	public boolean isB_next() {
		return b_next;
	}

	public void setB_next(boolean b_next) {
		this.b_next = b_next;
	}

	public int getB_total() {
		return b_total;
	}

	public void setB_total(int b_total) {
		this.b_total = b_total;
	}

	public Book_Criteria getBcri() {
		return bcri;
	}

	public void setBcri(Book_Criteria bcri) {
		this.bcri = bcri;
	}

	
	
	public Book_PageVO(Book_Criteria bcri,int b_total) {
		this.bcri = bcri; //페이지 당 게시글 수 
		this.b_total = b_total; //게시글 전체 수 ,45
		
		this.b_endPage = (int)(Math.ceil(bcri.getB_pageNum()/5.0))*5;//
		
		this.b_startPage = this.b_endPage-4; //'1' , 시작 페이징 번호
		
		int b_realEnd = (int)(Math.ceil(b_total*1.0/bcri.getB_amount())); //게시물 총페이지수
		if(b_realEnd < this.b_endPage) {
			this.b_endPage=b_realEnd;
		}
		this.b_prev = this.b_startPage>1; //번호가 2가 생성 되면 이전 버튼 생성
		this.b_next = this.b_endPage < b_realEnd;
		
		System.out.println("Book_PageVo bcri : "+bcri);
		System.out.println("total : "+b_total);
		System.out.println("endpage : "+this.b_endPage);
		System.out.println("startpage : "+this.b_startPage);
		System.out.println("realend : "+b_realEnd);
	}

	@Override
	public String toString() {
		return "Book_PageVO [b_startPage=" + b_startPage + ", b_endPage=" + b_endPage + ", b_prev=" + b_prev
				+ ", b_next=" + b_next + ", b_total=" + b_total + ", bcri=" + bcri + "]";
	}

}
