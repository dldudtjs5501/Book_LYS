package com.lys.model;

public class MailVO {
	//������ �̿��� ȸ�� ���̵� ����
	
	private String tomail; //�޴� ��
	private String title;
	private String contents;
	private String from; //������
	
	//getter / setter
	public String getTomail() {
		return tomail;
	}
	public void setTomail(String tomail) {
		this.tomail = tomail;
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
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
	@Override
	public String toString() {
		return "MailVO [tomail=" + tomail + ", title=" + title + ", contents=" + contents + ", from=" + from + "]";
	}
	
}
