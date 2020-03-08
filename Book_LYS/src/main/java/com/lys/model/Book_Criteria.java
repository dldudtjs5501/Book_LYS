package com.lys.model;

public class Book_Criteria {
	
	//상품 페이지 번호
	private int b_pageNum;
	
	//한 페이지 당 데이터 처리 갯수(6)
	private int b_amount;
	
	//상품 검색 키워드
	private String keyword;
	
	//처음 상품 게시판 접근 한 경우 페이지 번호와 게시글 수를 가져 올 수 없으므로 초기 설정값.
	public Book_Criteria() {
		this.b_pageNum = 1;
		this.b_amount = 6;
	}
	
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public int getB_pageNum() {
		return b_pageNum;
	}

	public void setB_pageNum(int b_pageNum) {
		this.b_pageNum = b_pageNum;
	}

	public int getB_amount() {
		return b_amount;
	}

	public void setB_amount(int b_amount) {
		this.b_amount = b_amount;
	}

	@Override
	public String toString() {
		return "Book_Criteria [b_pageNum=" + b_pageNum + ", b_amount=" + b_amount + ", keyword=" + keyword + "]";
	}

	
}
