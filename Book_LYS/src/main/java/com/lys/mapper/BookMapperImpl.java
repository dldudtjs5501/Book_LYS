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
	
	//��ǰ ���
	@Override
	public void bookwrite(BookVO book) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".bookwrite",book);
	}
	
	//��ǰ ���
	@Override
	public List<BookVO> booklist() throws Exception {
		List<BookVO>list = sqlSession.selectList(namespace+".booklist");
		return list;
	}
	
	//����¡ ó���� ��ǰ ��� 
	@Override
	public List<BookVO> booklistpaging(Book_Criteria bcri) throws Exception {
		List list = sqlSession.selectList(namespace+".booklistpaging",bcri);
		return list;
	}
	
	//����¡ �� �Խñ� ��ü ����
	@Override
	public int bookcount(Book_Criteria bcri) throws Exception {
		int b_total = sqlSession.selectOne(namespace+".bookcount",bcri);
		return b_total;
	}
	
	//��ǰ �� ���� Ȯ��
	@Override
	public BookVO bookdetail(int bookno) throws Exception {
		BookVO bookdao = sqlSession.selectOne(namespace+".bookdetail",bookno);
		return bookdao;
	}
	
	//��ǰ ���� ����
	@Override
	public void bookmodify(BookVO book) throws Exception {
		sqlSession.update(namespace+".bookmodify",book);
		
	}
	
	//��ǰ �̹��� ����
	@Override
	public String bookimgurl(int bookno) throws Exception {
		return sqlSession.selectOne(namespace+".bookimgurl",bookno);
		
	}
	
	//��ǰ ���� ����
	@Override
	public void bookdel(int bookno) throws Exception {
		sqlSession.delete(namespace+".bookdel",bookno);
		
	}

}
