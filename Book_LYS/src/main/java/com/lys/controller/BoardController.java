package com.lys.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.lys.model.BoardVO;
import com.lys.model.Criteria;
import com.lys.model.MemberVO;
import com.lys.model.PageVO;
import com.lys.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService bservice;
	
	//localhost:8080/booklys/register 페이지로 단순 이동
	@RequestMapping(value="boardreg" , method=RequestMethod.GET)
	public String registGet() throws Exception{
		//System.out.println("세션 아이디 : "+member.getUserid());
		//System.out.println("세션 : "+member);
		return "board/BoardWrite";
	}
	
	//글쓰기 입력 란에 값을 입력 후 Database에 저장 하고 BoardWrite로 이동 
	@RequestMapping(value="boardreg" , method=RequestMethod.POST)
	public String registPost(@SessionAttribute("member") MemberVO member,BoardVO board ,HttpSession session) throws Exception{
		//(로그인 된 아이디만 글쓰기 가능)
		board.setWriter(member.getUserid());
		bservice.boardWrite(board);
		return "redirect:boardlist";
	}
	
	//데이터베이스에 저장 된 값 전부 화면에 출력
	/*@RequestMapping(value="boardlist" , method=RequestMethod.GET)
	public String listGet(Model model) throws Exception{
		//System.out.println("boardlist ............");
		model.addAttribute("list", bservice.boardList());
		return "board/BoardList";
	}*/
	
	//페이징 처리 된 게시글 리스트 
	@RequestMapping(value="boardlist" , method=RequestMethod.GET)
	public String PaginList(Criteria cri,Model model) throws Exception{
		
		int total=bservice.boardCount(cri); //'헬' = 1
		
		PageVO pv = new PageVO(cri,total); //cri = 페이지당 처리 된 게시글 수 / total = 키워드로 인한 게시글 갯수
		
		System.out.println("keyword : " + cri.getKeyword());
		System.out.println("pv: "+pv);
		System.out.println("total : "+total);
		System.out.println("bservice.boardListPaging(cri) :"+bservice.boardListPaging(cri));
		
		model.addAttribute("list",bservice.boardListPaging(cri)); //페이징에 대한 정보
		model.addAttribute("page", pv);
		//model.addAttribute("list", bservice.boardList());
		
		return "board/BoardList";
	}
	
	//리스트의 tilte 선택 시 상세 내용 출력
	@RequestMapping(value="boarddtail" , method=RequestMethod.GET)
	public String detailGet(@RequestParam ("no") int bno, Model model) throws Exception {
		//System.out.println("detail page........");
		
		//조회수 증가
		bservice.pluscnt(bno);
		model.addAttribute("bno", bservice.boardDetail(bno));
		return "board/BoardDetail";
	}
	//게시판 수정 페이지 단순 이동 - 글 번호에 해당 내용을 페이지에 저장.
	@RequestMapping(value="boardmodify" , method=RequestMethod.GET)
	public String modifyGet(@RequestParam int modify ,Model model) throws Exception {
		//System.out.println("update page..........");
		model.addAttribute("modify", bservice.boardDetail(modify)); //상세 정보에 대한 내용 저장.
		return "board/BoardModify";
	}
	//게시판 수정 및 등록
	@RequestMapping(value="boardmodify" , method=RequestMethod.POST)
	public String modifyPost(BoardVO board) throws Exception {	
		bservice.boardModify(board);
		
		return "redirect:boardlist?bno="+board.getBno();
	}
	
	//게시판 글 번호에 해당 하는 글 삭제
	@RequestMapping(value="boarddel" , method=RequestMethod.GET)
	public String delGet(BoardVO board) throws Exception {
		//로그인 된 아이디만 삭제 가능
		bservice.boardDel(board);
		return "redirect:boardlist";
	}
	
}
