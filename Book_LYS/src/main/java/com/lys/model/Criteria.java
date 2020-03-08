package com.lys.model;

//페이징 기법에서 1페이지당 10개의 게시글 출력
public class Criteria {

		//페이지 번호
		private int pageNum;
		
		//한 페이지 당 데이터 처리 갯수(10)
		private int amount;
		
		//게시글 검색 키워드
		private String keyword;
		
		//처음 게시판 접근 한 경우 페이지 번호와 게시글 수를 가져 올 수 없으므로 초기 설정값.
		public Criteria() {
			this.pageNum = 1;
			this.amount = 10;
		}

		//getter / setter
		public int getPageNum() {
			return pageNum;
		}

		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}
		
		public String getKeyword() {
			return keyword;
		}

		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}

		@Override
		public String toString() {
			return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", keyword=" + keyword + "]";
		}
		
		
		
		
}
