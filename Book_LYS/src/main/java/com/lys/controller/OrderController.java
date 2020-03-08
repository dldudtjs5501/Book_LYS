package com.lys.controller;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.lys.model.Book_OrderDetailsVO;
import com.lys.model.Book_OrderVO;
import com.lys.model.MemberVO;
import com.lys.model.OrderListDetailVO;
import com.lys.service.CartService;

@Controller
public class OrderController {
	
	@Autowired
	private CartService cservice;
	
	//주문자의 정보와 주문 시 카트에 담긴 상품 정보 저장 후 카트에 담긴 상품 삭제
	@RequestMapping(value="order" , method=RequestMethod.POST)
	public String order(@SessionAttribute("member")MemberVO member,Book_OrderVO order,Book_OrderDetailsVO orderdetail) throws Exception {
		System.out.println("order..................");
		
		System.out.println("login : "+member.getUserid());
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = " "; //6자리 random 값
		
		//System.out.println("year : "+year); //2020
		//System.out.println("ym : "+ym); //2020년 02월 (202002)
		//System.out.println("ymd : "+ymd); //2020년 02월 14일(20200214)
		
		for(int i=1; i<=6; i++) {
			subNum += (int)(Math.random()*10);
		}
		//System.out.println("subNum : "+subNum);
		String orderid = ymd+"_"+subNum; //20200214_222222
		
		//주문 정보 insert
		order.setOrderid(orderid);//주문 번호
		//System.out.println("orderid : " + order.getOrderid());
		order.setUserid(member.getUserid()); //로그인 정보
		cservice.orderinfo(order);	
		
		//주문 후 해당 카트의 정보 저장
		orderdetail.setOrderid(orderid);
		cservice.orderinfo_detail(orderdetail);
		
		//주문 완료 후 로그인 된 아이디의 카트 리스트 삭제
		cservice.cartalldelete(member.getUserid());
		
		return "redirect:OrderList";
	}
	
	//주문 목록 출력
	@RequestMapping(value="OrderList" , method=RequestMethod.GET)
	public void orderlist(@SessionAttribute("member")MemberVO member, Book_OrderVO order,Model model)throws Exception{
		
		System.out.println("orderlist ..........");
		
		System.out.println("userid : "+member.getUserid());
		order.setUserid(member.getUserid());
		
		List<Book_OrderVO> orderlist = cservice.orderList(order);
		model.addAttribute("orderList",orderlist);
	}
	
	//주문 목록 상세 정보 출력
	@RequestMapping(value="orderlistdetail" , method=RequestMethod.GET)
	public String orderlistdetail(@SessionAttribute("member")MemberVO member , @RequestParam String orderid,
			Book_OrderVO order,Model model) throws Exception{
		System.out.println("orderlistdetail.......................");
		//System.out.println("userid : "+member.getUserid());
		//System.out.println("orderid : "+orderid);
		
		order.setUserid(member.getUserid());
		order.setOrderid(orderid);
		
		List<OrderListDetailVO> orderview = cservice.orderlistdetail(order);
		
		model.addAttribute("orderview",orderview);
		return "OrderDetailList";
	}
	
}
