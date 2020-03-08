package com.lys.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.lys.model.Book_OrderDetailsVO;
import com.lys.model.Book_OrderVO;
import com.lys.model.CartVO;
import com.lys.model.OrderListDetailVO;

@Repository
public class CartMapperImpl implements CartMapper{
	
	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.lys.mapper.CartMapper";

	//카트 담기
	@Override
	public void cartinsert(CartVO cart) throws Exception {
		sqlSession.insert(namespace+".cartinsert",cart);
		
	}
	
	//카트에 상품 존재 유무 확인 하기
	@Override
	public int countcart(int bookno, String writer) throws Exception {
		Map<String,Object>map = new HashMap<String,Object>();
		map.put("bookno", bookno);
		map.put("writer", writer);
		return sqlSession.selectOne(namespace+".countcart",map);
	}
	
	//카트 리스트 
	@Override
	public List<CartVO> listcart(String writer) throws Exception {
		return sqlSession.selectList(namespace+".listcart",writer);
	}

	//카트 전체 금액
	@Override
	public int sumMoney(String writer) throws Exception {
		
		return sqlSession.selectOne(namespace+".sumMoney",writer);
	}

	//카트 상품 삭제
	@Override
	public void deletecart(int cart_id) throws Exception {
		sqlSession.delete(namespace+".deletecart",cart_id);
		
	}

	//카트 수정
	@Override
	public int modifycart(CartVO cart) throws Exception {
		return sqlSession.update(namespace+".modifycart",cart);
		
	}
	
	//카트 상품 추가 시 수량 수정
	@Override
	public void updatecart(CartVO cart) throws Exception {
		sqlSession.update(namespace+".updatecart",cart);
		
	}

	//주문 정보
	@Override
	public void orderinfo(Book_OrderVO order) throws Exception {
		sqlSession.insert(namespace+".orderinfo",order);
		
	}

	//주문 상세 정보
	@Override
	public void orderinfo_detail(Book_OrderDetailsVO orderdetail) throws Exception {
		sqlSession.insert(namespace+".orderinfo_dtail",orderdetail);
		
	}
	
	//주문 후 카트 리스트 삭제
	@Override
	public void cartalldelete(String writer) throws Exception {
		sqlSession.delete(namespace+".cartalldelete",writer);
	}

	//로그인 후 고객의 주문 리스트 
	@Override
	public List<Book_OrderVO> orderList(Book_OrderVO order) throws Exception {
		return sqlSession.selectList(namespace+".orderList",order); 
	}

	//주문 번호에 따른 상세 내역
	@Override
	public List<OrderListDetailVO> orderlistdetail(Book_OrderVO order) throws Exception {
		return sqlSession.selectList(namespace+".orderlistdetail",order);
	}

}
