package com.lys.service;

import java.util.List;

import com.lys.model.BoardVO;
import com.lys.model.Criteria;

public interface BoardService {
	
	//�Խ��� �۾���
	public void boardWrite(BoardVO board) throws Exception;
	
	//�Խ��� ����Ʈ ���� �ֱ�
	public List<BoardVO> boardList()throws Exception;
	
	//�Խ��� �� ���� �����ֱ�
	public BoardVO boardDetail(int bno) throws Exception;
	
	//����¡ �� �Խñ� ����Ʈ
	public List<BoardVO> boardListPaging(Criteria cri)throws Exception;
	
	//����¡ �� �Խñ� ��ü ����
	public int boardCount(Criteria cri)throws Exception;
	
	//�Խ��� ����
	public void boardModify(BoardVO board) throws Exception;
	
	//�Խ��� �� ����
	public void boardDel(BoardVO board) throws Exception;
	
	//�Խ��� ��ȸ�� �ø���
	public void pluscnt(int bno) throws Exception;
		
}
