package com.lys.service;

import java.util.List;

import com.lys.model.BookVO;
import com.lys.model.Book_Criteria;
import com.lys.model.Criteria;

public interface BookService {
	
	//상품 등록
	public void bookwrite(BookVO book)throws Exception;
	
	//상품 목록
	public List<BookVO> booklist()throws Exception;
	
	//상품 목록 페이징 처리
	public List<BookVO> booklistpaging(Book_Criteria bcri)throws Exception;
	
	//페이징 시 상품 전체 갯수
	public int boardcount(Book_Criteria bcri)throws Exception;
	
	//상품 상세 정보 보기
	public BookVO bookdetail(int bookno)throws Exception;
	
	
	//상품 정보 수정하기
	public void bookmodify(BookVO book)throws Exception;
	
	//상품 이미지 삭제
	public String bookimgurl(int bookno) throws Exception;
	
	//상품 삭제
	public void bookdel(int bookno)throws Exception;
}
