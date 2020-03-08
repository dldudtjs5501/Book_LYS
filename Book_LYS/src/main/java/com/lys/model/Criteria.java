package com.lys.model;

//����¡ ������� 1�������� 10���� �Խñ� ���
public class Criteria {

		//������ ��ȣ
		private int pageNum;
		
		//�� ������ �� ������ ó�� ����(10)
		private int amount;
		
		//�Խñ� �˻� Ű����
		private String keyword;
		
		//ó�� �Խ��� ���� �� ��� ������ ��ȣ�� �Խñ� ���� ���� �� �� �����Ƿ� �ʱ� ������.
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
