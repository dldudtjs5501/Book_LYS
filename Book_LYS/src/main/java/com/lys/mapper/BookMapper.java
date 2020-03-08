package com.lys.mapper;

import java.util.List;

import com.lys.model.BoardVO;
import com.lys.model.BookVO;
import com.lys.model.Book_Criteria;
import com.lys.model.Criteria;

public interface BookMapper {
	
	//��ǰ ���
	public void bookwrite(BookVO book)throws Exception;
	
	//��ǰ ���
	public List<BookVO> booklist()throws Exception;
	
	//����¡ ó�� �� ��ǰ ����Ʈ
	public List<BookVO> booklistpaging(Book_Criteria bcri)throws Exception;
	
	//����¡ �� ��ǰ ��ü ����
	public int bookcount(Book_Criteria bcri)throws Exception;
	
	//��ǰ �� ���� ����
	public BookVO bookdetail(int bookno)throws Exception;
	
	//��ǰ ���� ����
	public void bookmodify(BookVO book) throws Exception;
	
	//��ǰ �̹��� ����
	public String bookimgurl(int bookno) throws Exception;
	
	//��ǰ ����
	public void bookdel(int bookno) throws Exception;
	
	
}
