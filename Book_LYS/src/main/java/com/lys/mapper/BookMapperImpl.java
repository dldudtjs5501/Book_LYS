package com.lys.mapper;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lys.model.BookVO;
import com.lys.model.Book_Criteria;

@Repository
public class BookMapperImpl implements BookMapper{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.lys.mapper.BookMapper";
	
	//상품 등록
	@Override
	public void bookwrite(BookVO book) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".bookwrite",book);
	}
	
	//상품 목록
	@Override
	public List<BookVO> booklist() throws Exception {
		List<BookVO>list = sqlSession.selectList(namespace+".booklist");
		return list;
	}
	
	//페이징 처리한 상품 목록 
	@Override
	public List<BookVO> booklistpaging(Book_Criteria bcri) throws Exception {
		List list = sqlSession.selectList(namespace+".booklistpaging",bcri);
		return list;
	}
	
	//페이징 시 게시글 전체 갯수
	@Override
	public int bookcount(Book_Criteria bcri) throws Exception {
		int b_total = sqlSession.selectOne(namespace+".bookcount",bcri);
		return b_total;
	}
	
	//상품 상세 정보 확인
	@Override
	public BookVO bookdetail(int bookno) throws Exception {
		BookVO bookdao = sqlSession.selectOne(namespace+".bookdetail",bookno);
		return bookdao;
	}
	
	//상품 정보 수정
	@Override
	public void bookmodify(BookVO book) throws Exception {
		sqlSession.update(namespace+".bookmodify",book);
		
	}
	
	//상품 이미지 삭제
	@Override
	public String bookimgurl(int bookno) throws Exception {
		return sqlSession.selectOne(namespace+".bookimgurl",bookno);
		
	}
	
	//상품 정보 삭제
	@Override
	public void bookdel(int bookno) throws Exception {
		sqlSession.delete(namespace+".bookdel",bookno);
		
	}

}
