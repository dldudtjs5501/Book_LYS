package com.lys.model;

public class PageVO {

	//페이징의 시작번호
	private int startPage;
	
	//페이징의 끝번호
	private int endPage;
	
	//페이징의 이전
	private boolean prev;
	
	//페이징의 다음
	private boolean next;
	
	//전체 건수
	private int total;
	
	//Criteria - 1페이지당 총 list 건수(1page - 10)
	private Criteria cri;

	public PageVO(Criteria cri , int total) {
		this.cri = cri; //페이지 당 게시글 수 
		this.total = total; //게시글 전체 수
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10; //총 페이지 갯수 (10개씩 3페이지)
		this.startPage = this.endPage-9; //'1' , 시작 페이징 번호
		
		int realEnd = (int)(Math.ceil(total*1.0/cri.getAmount())); //30
		if(realEnd < this.endPage) {
			this.endPage=realEnd;
		}
		this.prev = this.startPage>1; //번호가 2가 생성 되면 이전 버튼 생성
		this.next = this.endPage < realEnd;
		
		System.out.println("startPage : "+this.startPage);
		System.out.println("endpage : "+this.endPage);
		System.out.println("realend : "+realEnd);
	}
	
	//getter / setter
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		System.out.println("PageVO endPage="+endPage);
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	@Override
	public String toString() {
		return "PageVO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", cri=" + cri + "]";
	}
	
	
	
}
