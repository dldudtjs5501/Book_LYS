package com.lys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lys.model.Book_Criteria;
import com.lys.model.Book_PageVO;
import com.lys.service.BookService;

@Controller
public class MainController {
	@Autowired
	private BookService Bservice;
	
	//main 페이지(상품 리스트 보여주기)
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String MainGet(Book_Criteria bcri,Model model) throws Exception{
		System.out.println("main...............");
		
		int b_total = Bservice.boardcount(bcri);
		
		System.out.println("controller bcri : "+bcri);
		System.out.println("controller total : "+b_total);
		System.out.println("keyword : "+bcri.getKeyword());
		
		Book_PageVO bp = new Book_PageVO(bcri,b_total);
	
		System.out.println("bp: "+bp);
		
		
		System.out.println("Bservice.booklistpaging(bcri) :"+Bservice.booklistpaging(bcri));
		
		model.addAttribute("list",Bservice.booklistpaging(bcri)); //페이징에 대한 정보
		model.addAttribute("page", bp);
		
		return "Book_lys";
	}
	
	//mail 페이지에서 상품 Detail 정보 확인
	@RequestMapping(value="mainbookdet" , method=RequestMethod.GET)
	public String MainBookDetGet(@RequestParam ("bookno") int bookno, Model model)throws Exception{
		System.out.println("Main book detail");
		model.addAttribute("bookno", Bservice.bookdetail(bookno));
		return "Book_lysDetail";
	}
	
}
