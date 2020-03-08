package com.lys.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.lys.model.Criteria;
import com.lys.model.MemberVO;
import com.lys.model.PageVO;
import com.lys.model.ReviewVO;
import com.lys.service.BookService;
import com.lys.service.ReviewService;

@Controller
@RequestMapping("Review")
public class ReviewController {
	
	@Autowired
	private ReviewService rservice;
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	//¥Ò±€ ∏ÆΩ∫∆Æ
	@RequestMapping(value="reviewlist")
	@ResponseBody
	public List<ReviewVO> reviewlistGet(@RequestParam("bookno") int bookno,ReviewVO review) throws Exception{
		System.out.println("reviewlist........................");
		
		return rservice.reviewlist(bookno);

	}

	//¥Ò±€ ¿€º∫
	@RequestMapping(value="reviewinsert")
	@ResponseBody
	public int reviewinsert(@SessionAttribute("member")MemberVO member,ReviewVO review)throws Exception{
		
		review.setR_writer(member.getUserid());
		
		int result = 0;
	
		System.out.println("reviewinsert ...........");
		
		System.out.println("bookno : "+review.getBookno());
		System.out.println("userid : "+review.getR_writer());
		System.out.println("contents : "+review.getR_contents());
		
		if(review.getR_contents().equals("")) {}
		else {
			result = rservice.reviewinsert(review);
		}
		return result;
	}
	//¥Ò±€ ºˆ¡§
	@ResponseBody
	@RequestMapping(value="reviewmodify")
	public int reviewmodify(@RequestParam("r_content")String r_contents,ReviewVO review)throws Exception{
			
		System.out.println("reviewmodify..................");
		
		review.setR_contents(r_contents);
		
		System.out.println("rno : "+review.getRno());
		System.out.println("rcontents : "+review.getR_contents());
		
		return rservice.reviewmodify(review);
	}
	
	//¥Ò±€ ªË¡¶
	@ResponseBody
	@RequestMapping(value="reviewdel{rno}")
	public int reviewdel(@PathVariable int rno ,ReviewVO review)throws Exception{
				
		System.out.println("reviewdel..................");
		System.out.println("rno : "+rno);
		review.setRno(rno);
		return rservice.reviewdel(review);
	}
	
}
