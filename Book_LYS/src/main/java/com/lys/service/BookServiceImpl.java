package com.lys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.mapper.BoardMapper;
import com.lys.mapper.BookMapper;
import com.lys.model.BookVO;
import com.lys.model.Book_Criteria;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookMapper Bm;
	
	//��ǰ ���
	@Override
	public void bookwrite(BookVO book) throws Exception {
		Bm.bookwrite(book);
		
	}
	
	//��ǰ ���
	@Override
	public List<BookVO> booklist() throws Exception {
		return Bm.booklist();
	}
	
	//��ǰ ��� ����¡ ó��
	@Override
	public List<BookVO> booklistpaging(Book_Criteria bcri) throws Exception {
		return Bm.booklistpaging(bcri);
	}
	
	//����¡ ó�� �� ��ǰ ��ü ���� �ľ�
	@Override
	public int boardcount(Book_Criteria bcri) throws Exception {
		return Bm.bookcount(bcri);
	}

	//��ǰ �� ���� Ȯ��
	@Override
	public BookVO bookdetail(int bookno) throws Exception {
		return Bm.bookdetail(bookno);
		
	}

	//��ǰ ���� ����
	@Override
	public void bookmodify(BookVO book) throws Exception {
		Bm.bookmodify(book);
		
	}
	
	//��ǰ �̹��� ����
	@Override
	public String bookimgurl(int bookno) throws Exception {
		return Bm.bookimgurl(bookno);
	}

	//��ǰ ����
	@Override
	public void bookdel(int bookno) throws Exception {
		Bm.bookdel(bookno);
		
	}

}
