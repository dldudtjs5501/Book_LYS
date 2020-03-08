package com.lys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.mapper.BoardMapper;
import com.lys.model.BoardVO;
import com.lys.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper bm;
	
	//�Խ��� �۾���
	@Override
	public void boardWrite(BoardVO board) throws Exception {
		bm.boardWrite(board);
	}
	//�Խ��� ����Ʈ
	@Override
	public List<BoardVO> boardList() throws Exception {
		//System.out.println("service list.....");
		return bm.boardList();
	}
	//�Խñ� ��ȣ�� ���� �� ����
	@Override
	public BoardVO boardDetail(int bno) throws Exception {
		return bm.boardDetail(bno);
	}
	//�Խñ� ��ȣ�� ���� ����
	@Override
	public void boardModify(BoardVO board) throws Exception {
		bm.boardModify(board);
		
	}
	//�Խñ� ����
	@Override
	public void boardDel(BoardVO board) throws Exception {
		bm.boardDel(board);
	}
	//����¡ ó�� �� �Խñ� ����Ʈ
	@Override
	public List<BoardVO> boardListPaging(Criteria cri) throws Exception {
		return bm.boardListPaging(cri); 
	}
	//����¡ ó�� �� �Խñ� ��ü ����
	@Override
	public int boardCount(Criteria cri) throws Exception {
		return bm.boardCount(cri);
	}
	
	//��ȸ�� �ø���
	@Override
	public void pluscnt(int bno) throws Exception {
		bm.pluscnt(bno);
	}
	
}
