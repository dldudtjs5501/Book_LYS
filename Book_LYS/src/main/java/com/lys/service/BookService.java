package com.lys.service;

import java.util.List;

import com.lys.model.BookVO;
import com.lys.model.Book_Criteria;
import com.lys.model.Criteria;

public interface BookService {
	
	//��ǰ ���
	public void bookwrite(BookVO book)throws Exception;
	
	//��ǰ ���
	public List<BookVO> booklist()throws Exception;
	
	//��ǰ ��� ����¡ ó��
	public List<BookVO> booklistpaging(Book_Criteria bcri)throws Exception;
	
	//����¡ �� ��ǰ ��ü ����
	public int boardcount(Book_Criteria bcri)throws Exception;
	
	//��ǰ �� ���� ����
	public BookVO bookdetail(int bookno)throws Exception;
	
	
	//��ǰ ���� �����ϱ�
	public void bookmodify(BookVO book)throws Exception;
	
	//��ǰ �̹��� ����
	public String bookimgurl(int bookno) throws Exception;
	
	//��ǰ ����
	public void bookdel(int bookno)throws Exception;
}
