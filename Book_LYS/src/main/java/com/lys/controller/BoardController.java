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
	
	//localhost:8080/booklys/register �������� �ܼ� �̵�
	@RequestMapping(value="boardreg" , method=RequestMethod.GET)
	public String registGet() throws Exception{
		//System.out.println("���� ���̵� : "+member.getUserid());
		//System.out.println("���� : "+member);
		return "board/BoardWrite";
	}
	
	//�۾��� �Է� ���� ���� �Է� �� Database�� ���� �ϰ� BoardWrite�� �̵� 
	@RequestMapping(value="boardreg" , method=RequestMethod.POST)
	public String registPost(@SessionAttribute("member") MemberVO member,BoardVO board ,HttpSession session) throws Exception{
		//(�α��� �� ���̵� �۾��� ����)
		board.setWriter(member.getUserid());
		bservice.boardWrite(board);
		return "redirect:boardlist";
	}
	
	//�����ͺ��̽��� ���� �� �� ���� ȭ�鿡 ���
	/*@RequestMapping(value="boardlist" , method=RequestMethod.GET)
	public String listGet(Model model) throws Exception{
		//System.out.println("boardlist ............");
		model.addAttribute("list", bservice.boardList());
		return "board/BoardList";
	}*/
	
	//����¡ ó�� �� �Խñ� ����Ʈ 
	@RequestMapping(value="boardlist" , method=RequestMethod.GET)
	public String PaginList(Criteria cri,Model model) throws Exception{
		
		int total=bservice.boardCount(cri); //'��' = 1
		
		PageVO pv = new PageVO(cri,total); //cri = �������� ó�� �� �Խñ� �� / total = Ű����� ���� �Խñ� ����
		
		System.out.println("keyword : " + cri.getKeyword());
		System.out.println("pv: "+pv);
		System.out.println("total : "+total);
		System.out.println("bservice.boardListPaging(cri) :"+bservice.boardListPaging(cri));
		
		model.addAttribute("list",bservice.boardListPaging(cri)); //����¡�� ���� ����
		model.addAttribute("page", pv);
		//model.addAttribute("list", bservice.boardList());
		
		return "board/BoardList";
	}
	
	//����Ʈ�� tilte ���� �� �� ���� ���
	@RequestMapping(value="boarddtail" , method=RequestMethod.GET)
	public String detailGet(@RequestParam ("no") int bno, Model model) throws Exception {
		//System.out.println("detail page........");
		
		//��ȸ�� ����
		bservice.pluscnt(bno);
		model.addAttribute("bno", bservice.boardDetail(bno));
		return "board/BoardDetail";
	}
	//�Խ��� ���� ������ �ܼ� �̵� - �� ��ȣ�� �ش� ������ �������� ����.
	@RequestMapping(value="boardmodify" , method=RequestMethod.GET)
	public String modifyGet(@RequestParam int modify ,Model model) throws Exception {
		//System.out.println("update page..........");
		model.addAttribute("modify", bservice.boardDetail(modify)); //�� ������ ���� ���� ����.
		return "board/BoardModify";
	}
	//�Խ��� ���� �� ���
	@RequestMapping(value="boardmodify" , method=RequestMethod.POST)
	public String modifyPost(BoardVO board) throws Exception {	
		bservice.boardModify(board);
		
		return "redirect:boardlist?bno="+board.getBno();
	}
	
	//�Խ��� �� ��ȣ�� �ش� �ϴ� �� ����
	@RequestMapping(value="boarddel" , method=RequestMethod.GET)
	public String delGet(BoardVO board) throws Exception {
		//�α��� �� ���̵� ���� ����
		bservice.boardDel(board);
		return "redirect:boardlist";
	}
	
}
