package com.lys.model;

public class Book_Criteria {
	
	//��ǰ ������ ��ȣ
	private int b_pageNum;
	
	//�� ������ �� ������ ó�� ����(6)
	private int b_amount;
	
	//��ǰ �˻� Ű����
	private String keyword;
	
	//ó�� ��ǰ �Խ��� ���� �� ��� ������ ��ȣ�� �Խñ� ���� ���� �� �� �����Ƿ� �ʱ� ������.
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
