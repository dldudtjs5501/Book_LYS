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
	
	//게시판 글쓰기
	@Override
	public void boardWrite(BoardVO board) throws Exception {
		bm.boardWrite(board);
	}
	//게시판 리스트
	@Override
	public List<BoardVO> boardList() throws Exception {
		//System.out.println("service list.....");
		return bm.boardList();
	}
	//게시글 번호에 대한 상세 내역
	@Override
	public BoardVO boardDetail(int bno) throws Exception {
		return bm.boardDetail(bno);
	}
	//게시글 번호에 대한 수정
	@Override
	public void boardModify(BoardVO board) throws Exception {
		bm.boardModify(board);
		
	}
	//게시글 삭제
	@Override
	public void boardDel(BoardVO board) throws Exception {
		bm.boardDel(board);
	}
	//페이징 처리 한 게시글 리스트
	@Override
	public List<BoardVO> boardListPaging(Criteria cri) throws Exception {
		return bm.boardListPaging(cri); 
	}
	//페이징 처리 한 게시글 전체 갯수
	@Override
	public int boardCount(Criteria cri) throws Exception {
		return bm.boardCount(cri);
	}
	
	//조회수 올리기
	@Override
	public void pluscnt(int bno) throws Exception {
		bm.pluscnt(bno);
	}
	
}
