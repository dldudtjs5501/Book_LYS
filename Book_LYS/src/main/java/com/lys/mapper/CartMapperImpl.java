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

	//īƮ ���
	@Override
	public void cartinsert(CartVO cart) throws Exception {
		sqlSession.insert(namespace+".cartinsert",cart);
		
	}
	
	//īƮ�� ��ǰ ���� ���� Ȯ�� �ϱ�
	@Override
	public int countcart(int bookno, String writer) throws Exception {
		Map<String,Object>map = new HashMap<String,Object>();
		map.put("bookno", bookno);
		map.put("writer", writer);
		return sqlSession.selectOne(namespace+".countcart",map);
	}
	
	//īƮ ����Ʈ 
	@Override
	public List<CartVO> listcart(String writer) throws Exception {
		return sqlSession.selectList(namespace+".listcart",writer);
	}

	//īƮ ��ü �ݾ�
	@Override
	public int sumMoney(String writer) throws Exception {
		
		return sqlSession.selectOne(namespace+".sumMoney",writer);
	}

	//īƮ ��ǰ ����
	@Override
	public void deletecart(int cart_id) throws Exception {
		sqlSession.delete(namespace+".deletecart",cart_id);
		
	}

	//īƮ ����
	@Override
	public int modifycart(CartVO cart) throws Exception {
		return sqlSession.update(namespace+".modifycart",cart);
		
	}
	
	//īƮ ��ǰ �߰� �� ���� ����
	@Override
	public void updatecart(CartVO cart) throws Exception {
		sqlSession.update(namespace+".updatecart",cart);
		
	}

	//�ֹ� ����
	@Override
	public void orderinfo(Book_OrderVO order) throws Exception {
		sqlSession.insert(namespace+".orderinfo",order);
		
	}

	//�ֹ� �� ����
	@Override
	public void orderinfo_detail(Book_OrderDetailsVO orderdetail) throws Exception {
		sqlSession.insert(namespace+".orderinfo_dtail",orderdetail);
		
	}
	
	//�ֹ� �� īƮ ����Ʈ ����
	@Override
	public void cartalldelete(String writer) throws Exception {
		sqlSession.delete(namespace+".cartalldelete",writer);
	}

	//�α��� �� ���� �ֹ� ����Ʈ 
	@Override
	public List<Book_OrderVO> orderList(Book_OrderVO order) throws Exception {
		return sqlSession.selectList(namespace+".orderList",order); 
	}

	//�ֹ� ��ȣ�� ���� �� ����
	@Override
	public List<OrderListDetailVO> orderlistdetail(Book_OrderVO order) throws Exception {
		return sqlSession.selectList(namespace+".orderlistdetail",order);
	}

}
