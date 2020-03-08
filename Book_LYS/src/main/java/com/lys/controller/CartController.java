package com.lys.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.lys.model.CartVO;
import com.lys.model.MemberVO;
import com.lys.service.AdminService;
import com.lys.service.CartService;

@Controller
@RequestMapping("/Cart")
public class CartController {
	
	@Autowired
	private CartService cservice;
	
	
	//īƮ�� ���� ��ǰ �����ͺ��̽��� ����
	@RequestMapping(value="Cartinsert",method=RequestMethod.POST)
	public String cartlistget(@SessionAttribute("member")MemberVO member,CartVO cart) throws Exception{
		System.out.println("cartinsert.............");
		
		//System.out.println("���̵� : "+member.getUserid());
		cart.setWriter(member.getUserid());
		
		//��ǰ�� īƮ�� ��� �ִ��� �˻�
		int count = cservice.countcart(cart.getBookno(), member.getUserid());
		
		if(count == 0) {
			//īƮ ���(īƮ�� ���� ��ǰ�� ����)
			cservice.cartinsert(cart);
		}else {
			//īƮ�� ���� ��ǰ �߰� �� ���� ����
			cservice.updatecart(cart);
		}
		return "redirect:CartList";
	}
	
	//īƮ ����Ʈ 
	@RequestMapping(value="CartList",method=RequestMethod.GET)
	public ModelAndView cartlist(@SessionAttribute("member")MemberVO member,ModelAndView mav,CartVO cart) throws Exception{
		
		System.out.println("cartlist.........");
		
		cart.setWriter(member.getUserid());
		
		List<CartVO> list = cservice.listcart(cart.getWriter()); //īƮ�� ��� ��ǰ ����
		
		Map<String ,Object> map = new HashMap<String , Object>();
		
		int sumMoney = cservice.sumMoney(member.getUserid()); //īƮ ��ü �ݾ� ȣ��
		System.out.println("sumMoney : "+sumMoney);
		
		int delivery = sumMoney >=50000?0:2500; //��ۺ�� ��ü �ݾ׿��� 50000�� �̻��̸� 0 / �ƴϸ� 2500�� ����
		
		map.put("list", list); //īƮ�� ��� ���� ��ü 
		map.put("sumMoney", sumMoney);
		map.put("delivery", delivery);
		map.put("allSum", sumMoney+delivery); //��ۺ� ���� ��ü ��ǰ �ݾ�
		System.out.println("list : "+list);
		
		map.put("count", list.size()); //��ٱ��� ��ǰ ���� Ȯ��
		mav.setViewName("Cart/CartList"); //view�� �̸� ����
		mav.addObject("map",map); //map ������ ����
		
		return mav;
	}
	
	//īƮ ��ǰ ����
	@RequestMapping(value="CartDel",method=RequestMethod.GET)
	public String deletecart(@RequestParam int cart_id)throws Exception{
		
		System.out.println("īƮ ���̵�!! : "+cart_id);
		cservice.deletecart(cart_id);
		return "redirect:CartList";
	}
	
	//īƮ ��ǰ ����
	@ResponseBody
	@RequestMapping(value="Cartupdate")
	public int updatecart(@RequestParam int bookno,@RequestParam int amount,
			@SessionAttribute("member")MemberVO member,CartVO cart)throws Exception{
		
		System.out.println("cartupdate.................");
		System.out.println("bookno : "+bookno);
		System.out.println("amount : "+amount);
		
		cart.setWriter(member.getUserid());
		cart.setBookno(bookno);
		cart.setAmount(amount);
		
		return cservice.modifycart(cart);
		
	}
}
