package com.lys.model;

public class PageVO {

	//����¡�� ���۹�ȣ
	private int startPage;
	
	//����¡�� ����ȣ
	private int endPage;
	
	//����¡�� ����
	private boolean prev;
	
	//����¡�� ����
	private boolean next;
	
	//��ü �Ǽ�
	private int total;
	
	//Criteria - 1�������� �� list �Ǽ�(1page - 10)
	private Criteria cri;

	public PageVO(Criteria cri , int total) {
		this.cri = cri; //������ �� �Խñ� �� 
		this.total = total; //�Խñ� ��ü ��
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10; //�� ������ ���� (10���� 3������)
		this.startPage = this.endPage-9; //'1' , ���� ����¡ ��ȣ
		
		int realEnd = (int)(Math.ceil(total*1.0/cri.getAmount())); //30
		if(realEnd < this.endPage) {
			this.endPage=realEnd;
		}
		this.prev = this.startPage>1; //��ȣ�� 2�� ���� �Ǹ� ���� ��ư ����
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
