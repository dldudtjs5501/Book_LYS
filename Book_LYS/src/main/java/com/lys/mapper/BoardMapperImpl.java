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
	
	//�Խ��� �۾���
	@Override
	public void boardWrite(BoardVO board) throws Exception {
		sqlSession.insert(namespace+".boardWrite",board);
		
	}
	//�Խ��� ����Ʈ
	@Override
	public List<BoardVO> boardList() throws Exception {
		List<BoardVO> list = sqlSession.selectList(namespace+".boardList");
		//System.out.println("mapper list ...........");
		return list;
	}
	//�Խñ� ��ȣ�� �ش� �ϴ� �� ����
	@Override
	public BoardVO boardDetail(int bno) throws Exception {
		BoardVO boarddao = sqlSession.selectOne(namespace+".boardDetail",bno);
		return boarddao;
	}
	//�Խñ� ����
	@Override
	public void boardModify(BoardVO  board) throws Exception {
		sqlSession.update(namespace+".boardModify",board);
		
	}
	
	//�Խñ� ����
	@Override
	public void boardDel(BoardVO board) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".boardDel",board);
		
	}
	//����¡ ó�� �� �Խ��� ����Ʈ
	@Override
	public List<BoardVO> boardListPaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".boardListPage",cri);
		return list;
	}
	//����¡ �� �Խñ� ��ü ����
	@Override
	public int boardCount(Criteria cri) throws Exception {
		int total = sqlSession.selectOne(namespace+".boardCount",cri);
		return total;
	}
	
	//��ȸ�� �ø���
	@Override
	public void pluscnt(int bno) throws Exception {
		sqlSession.update(namespace+".pluscnt",bno);
	}
}
