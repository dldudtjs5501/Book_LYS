package com.lys.model;

public class Book_PageVO {
	
	//����¡�� ���۹�ȣ
	private int b_startPage;
		
	//����¡�� ����ȣ
	private int b_endPage;
		
	//����¡�� ����
	private boolean b_prev;
		
	//����¡�� ����
	private boolean b_next;
		
	//��ü �Ǽ�
	private int b_total;
		
	//Criteria - 1�������� �� list �Ǽ�(1page - 6)
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
		this.bcri = bcri; //������ �� �Խñ� �� 
		this.b_total = b_total; //�Խñ� ��ü �� ,45
		
		this.b_endPage = (int)(Math.ceil(bcri.getB_pageNum()/5.0))*5;//
		
		this.b_startPage = this.b_endPage-4; //'1' , ���� ����¡ ��ȣ
		
		int b_realEnd = (int)(Math.ceil(b_total*1.0/bcri.getB_amount())); //�Խù� ����������
		if(b_realEnd < this.b_endPage) {
			this.b_endPage=b_realEnd;
		}
		this.b_prev = this.b_startPage>1; //��ȣ�� 2�� ���� �Ǹ� ���� ��ư ����
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
