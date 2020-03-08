package com.lys.mapper;

import java.util.List;

import com.lys.model.Book_OrderDetailsVO;
import com.lys.model.Book_OrderVO;
import com.lys.model.CartVO;
import com.lys.model.OrderListDetailVO;

public interface CartMapper {
	
	//카트 담기
	public void cartinsert(CartVO cart)throws Exception;
	
	//카트 상품 유무 확인 하기
	public int countcart(int bookno , String writer)throws Exception;
	
	//카트 리스트
	public List<CartVO> listcart(String writer)throws Exception;
	
	//카트 전체 금액
	public int sumMoney(String writer)throws Exception;
	
	//카트 상품 삭제
	public void deletecart(int cart_id)throws Exception;
	
	//카트 상품 수정
	public int modifycart(CartVO cart)throws Exception;
	
	//카트 상품 추가 시 수량 수정
	public void updatecart(CartVO cart)throws Exception;
	
	//주문 정보
	public void orderinfo(Book_OrderVO order)throws Exception;
	
	//주문 상세 정보
	public void orderinfo_detail(Book_OrderDetailsVO orderdetail)throws Exception;
	
	//주문 완료 후 카트 list 삭제
	public void cartalldelete(String writer)throws Exception;
	
	//로그인 한 고객의 주문 리스트
	public List<Book_OrderVO> orderList(Book_OrderVO order)throws Exception; 
	
	//주문 번호에 따른 상세 내역 리스트
	public List<OrderListDetailVO> orderlistdetail(Book_OrderVO order)throws Exception;
	
}
