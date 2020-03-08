package com.lys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.mapper.CartMapper;
import com.lys.model.Book_OrderDetailsVO;
import com.lys.model.Book_OrderVO;
import com.lys.model.CartVO;
import com.lys.model.OrderListDetailVO;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartMapper cm;
	
	//카트 담기
	@Override
	public void cartinsert(CartVO cart) throws Exception {
		cm.cartinsert(cart);
	}
	
	//카트에 상품 담긴 유무 확인
	@Override
	public int countcart(int bookno, String writer) throws Exception {
		return cm.countcart(bookno, writer);
	}

	//카트 리스트
	@Override
	public List<CartVO> listcart(String writer) throws Exception {
		return cm.listcart(writer);
	}

	//카트 전체 금액
	@Override
	public int sumMoney(String writer) throws Exception {
		return cm.sumMoney(writer);
	}

	//카트 상품 삭제
	@Override
	public void deletecart(int cart_id) throws Exception {
		cm.deletecart(cart_id);
		
	}
	
	//카트 수정
	@Override
	public int modifycart(CartVO cart) throws Exception {
		return cm.modifycart(cart);
		
	}
	
	//카트 상품 추가 시 수량 수정
	@Override
	public void updatecart(CartVO cart) throws Exception {
		cm.updatecart(cart);
	}
	
	//주문 정보
	@Override
	public void orderinfo(Book_OrderVO order) throws Exception {
		cm.orderinfo(order);
	}

	//주문 상세 정보
	@Override
	public void orderinfo_detail(Book_OrderDetailsVO orderdetail) throws Exception {
		cm.orderinfo_detail(orderdetail);
	}

	//주문 후 카트 리스트 삭제
	@Override
	public void cartalldelete(String writer) throws Exception {
		cm.cartalldelete(writer);
	}

	//로그인 한 사용자의 주문 리스트
	@Override
	public List<Book_OrderVO> orderList(Book_OrderVO order) throws Exception {
		return cm.orderList(order);
	}

	//주문 번호에 따른 상세 내역
	@Override
	public List<OrderListDetailVO> orderlistdetail(Book_OrderVO order) throws Exception {
		return cm.orderlistdetail(order);
	}
	
}
