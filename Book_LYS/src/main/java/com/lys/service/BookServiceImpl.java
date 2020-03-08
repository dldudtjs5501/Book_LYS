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
	
	//상품 등록
	@Override
	public void bookwrite(BookVO book) throws Exception {
		Bm.bookwrite(book);
		
	}
	
	//상품 목록
	@Override
	public List<BookVO> booklist() throws Exception {
		return Bm.booklist();
	}
	
	//상품 목록 페이징 처리
	@Override
	public List<BookVO> booklistpaging(Book_Criteria bcri) throws Exception {
		return Bm.booklistpaging(bcri);
	}
	
	//페이징 처리 한 상품 전체 갯수 파악
	@Override
	public int boardcount(Book_Criteria bcri) throws Exception {
		return Bm.bookcount(bcri);
	}

	//상품 상세 정보 확인
	@Override
	public BookVO bookdetail(int bookno) throws Exception {
		return Bm.bookdetail(bookno);
		
	}

	//상품 정보 수정
	@Override
	public void bookmodify(BookVO book) throws Exception {
		Bm.bookmodify(book);
		
	}
	
	//상품 이미지 삭제
	@Override
	public String bookimgurl(int bookno) throws Exception {
		return Bm.bookimgurl(bookno);
	}

	//상품 삭제
	@Override
	public void bookdel(int bookno) throws Exception {
		Bm.bookdel(bookno);
		
	}

}
