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
	
	
	//카트에 담은 상품 데이터베이스에 저장
	@RequestMapping(value="Cartinsert",method=RequestMethod.POST)
	public String cartlistget(@SessionAttribute("member")MemberVO member,CartVO cart) throws Exception{
		System.out.println("cartinsert.............");
		
		//System.out.println("아이디 : "+member.getUserid());
		cart.setWriter(member.getUserid());
		
		//상품이 카트에 담겨 있는지 검사
		int count = cservice.countcart(cart.getBookno(), member.getUserid());
		
		if(count == 0) {
			//카트 담기(카트에 담은 상품이 없음)
			cservice.cartinsert(cart);
		}else {
			//카트에 같은 상품 추가 시 수량 변경
			cservice.updatecart(cart);
		}
		return "redirect:CartList";
	}
	
	//카트 리스트 
	@RequestMapping(value="CartList",method=RequestMethod.GET)
	public ModelAndView cartlist(@SessionAttribute("member")MemberVO member,ModelAndView mav,CartVO cart) throws Exception{
		
		System.out.println("cartlist.........");
		
		cart.setWriter(member.getUserid());
		
		List<CartVO> list = cservice.listcart(cart.getWriter()); //카트에 담긴 상품 정보
		
		Map<String ,Object> map = new HashMap<String , Object>();
		
		int sumMoney = cservice.sumMoney(member.getUserid()); //카트 전체 금액 호출
		System.out.println("sumMoney : "+sumMoney);
		
		int delivery = sumMoney >=50000?0:2500; //배송비는 전체 금액에서 50000원 이상이면 0 / 아니면 2500원 적용
		
		map.put("list", list); //카트에 담긴 물건 전체 
		map.put("sumMoney", sumMoney);
		map.put("delivery", delivery);
		map.put("allSum", sumMoney+delivery); //배송비 포함 전체 상품 금액
		System.out.println("list : "+list);
		
		map.put("count", list.size()); //장바구니 상품 유무 확인
		mav.setViewName("Cart/CartList"); //view의 이름 저장
		mav.addObject("map",map); //map 변수에 저장
		
		return mav;
	}
	
	//카트 상품 삭제
	@RequestMapping(value="CartDel",method=RequestMethod.GET)
	public String deletecart(@RequestParam int cart_id)throws Exception{
		
		System.out.println("카트 아이디!! : "+cart_id);
		cservice.deletecart(cart_id);
		return "redirect:CartList";
	}
	
	//카트 상품 수정
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
