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
	
	//�ֹ����� ������ �ֹ� �� īƮ�� ��� ��ǰ ���� ���� �� īƮ�� ��� ��ǰ ����
	@RequestMapping(value="order" , method=RequestMethod.POST)
	public String order(@SessionAttribute("member")MemberVO member,Book_OrderVO order,Book_OrderDetailsVO orderdetail) throws Exception {
		System.out.println("order..................");
		
		System.out.println("login : "+member.getUserid());
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = " "; //6�ڸ� random ��
		
		//System.out.println("year : "+year); //2020
		//System.out.println("ym : "+ym); //2020�� 02�� (202002)
		//System.out.println("ymd : "+ymd); //2020�� 02�� 14��(20200214)
		
		for(int i=1; i<=6; i++) {
			subNum += (int)(Math.random()*10);
		}
		//System.out.println("subNum : "+subNum);
		String orderid = ymd+"_"+subNum; //20200214_222222
		
		//�ֹ� ���� insert
		order.setOrderid(orderid);//�ֹ� ��ȣ
		//System.out.println("orderid : " + order.getOrderid());
		order.setUserid(member.getUserid()); //�α��� ����
		cservice.orderinfo(order);	
		
		//�ֹ� �� �ش� īƮ�� ���� ����
		orderdetail.setOrderid(orderid);
		cservice.orderinfo_detail(orderdetail);
		
		//�ֹ� �Ϸ� �� �α��� �� ���̵��� īƮ ����Ʈ ����
		cservice.cartalldelete(member.getUserid());
		
		return "redirect:OrderList";
	}
	
	//�ֹ� ��� ���
	@RequestMapping(value="OrderList" , method=RequestMethod.GET)
	public void orderlist(@SessionAttribute("member")MemberVO member, Book_OrderVO order,Model model)throws Exception{
		
		System.out.println("orderlist ..........");
		
		System.out.println("userid : "+member.getUserid());
		order.setUserid(member.getUserid());
		
		List<Book_OrderVO> orderlist = cservice.orderList(order);
		model.addAttribute("orderList",orderlist);
	}
	
	//�ֹ� ��� �� ���� ���
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
