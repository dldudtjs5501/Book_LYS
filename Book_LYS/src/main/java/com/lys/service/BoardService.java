package com.lys.service;

import java.util.List;

import com.lys.model.BoardVO;
import com.lys.model.Criteria;

public interface BoardService {
	
	//게시판 글쓰기
	public void boardWrite(BoardVO board) throws Exception;
	
	//게시판 리스트 보여 주기
	public List<BoardVO> boardList()throws Exception;
	
	//게시판 상세 내용 보여주기
	public BoardVO boardDetail(int bno) throws Exception;
	
	//페이징 한 게시글 리스트
	public List<BoardVO> boardListPaging(Criteria cri)throws Exception;
	
	//페이징 시 게시글 전체 갯수
	public int boardCount(Criteria cri)throws Exception;
	
	//게시판 수정
	public void boardModify(BoardVO board) throws Exception;
	
	//게시판 글 삭제
	public void boardDel(BoardVO board) throws Exception;
	
	//게시판 조회수 올리기
	public void pluscnt(int bno) throws Exception;
		
}
