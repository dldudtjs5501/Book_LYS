package com.lys.mapper;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lys.model.BoardVO;
import com.lys.model.Criteria;

@Repository
public class BoardMapperImpl implements BoardMapper{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.lys.mapper.BoardMapper";
	
	//게시판 글쓰기
	@Override
	public void boardWrite(BoardVO board) throws Exception {
		sqlSession.insert(namespace+".boardWrite",board);
		
	}
	//게시판 리스트
	@Override
	public List<BoardVO> boardList() throws Exception {
		List<BoardVO> list = sqlSession.selectList(namespace+".boardList");
		//System.out.println("mapper list ...........");
		return list;
	}
	//게시글 번호에 해당 하는 상세 내역
	@Override
	public BoardVO boardDetail(int bno) throws Exception {
		BoardVO boarddao = sqlSession.selectOne(namespace+".boardDetail",bno);
		return boarddao;
	}
	//게시글 수정
	@Override
	public void boardModify(BoardVO  board) throws Exception {
		sqlSession.update(namespace+".boardModify",board);
		
	}
	
	//게시글 삭제
	@Override
	public void boardDel(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".boardDel",board);
		
	}
	//페이징 처리 된 게시판 리스트
	@Override
	public List<BoardVO> boardListPaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".boardListPage",cri);
		return list;
	}
	//페이징 시 게시글 전체 갯수
	@Override
	public int boardCount(Criteria cri) throws Exception {
		int total = sqlSession.selectOne(namespace+".boardCount",cri);
		return total;
	}
	
	//조회수 올리기
	@Override
	public void pluscnt(int bno) throws Exception {
		sqlSession.update(namespace+".pluscnt",bno);
	}
}
