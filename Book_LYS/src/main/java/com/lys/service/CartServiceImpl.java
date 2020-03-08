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
	
	//īƮ ���
	@Override
	public void cartinsert(CartVO cart) throws Exception {
		cm.cartinsert(cart);
	}
	
	//īƮ�� ��ǰ ��� ���� Ȯ��
	@Override
	public int countcart(int bookno, String writer) throws Exception {
		return cm.countcart(bookno, writer);
	}

	//īƮ ����Ʈ
	@Override
	public List<CartVO> listcart(String writer) throws Exception {
		return cm.listcart(writer);
	}

	//īƮ ��ü �ݾ�
	@Override
	public int sumMoney(String writer) throws Exception {
		return cm.sumMoney(writer);
	}

	//īƮ ��ǰ ����
	@Override
	public void deletecart(int cart_id) throws Exception {
		cm.deletecart(cart_id);
		
	}
	
	//īƮ ����
	@Override
	public int modifycart(CartVO cart) throws Exception {
		return cm.modifycart(cart);
		
	}
	
	//īƮ ��ǰ �߰� �� ���� ����
	@Override
	public void updatecart(CartVO cart) throws Exception {
		cm.updatecart(cart);
	}
	
	//�ֹ� ����
	@Override
	public void orderinfo(Book_OrderVO order) throws Exception {
		cm.orderinfo(order);
	}

	//�ֹ� �� ����
	@Override
	public void orderinfo_detail(Book_OrderDetailsVO orderdetail) throws Exception {
		cm.orderinfo_detail(orderdetail);
	}

	//�ֹ� �� īƮ ����Ʈ ����
	@Override
	public void cartalldelete(String writer) throws Exception {
		cm.cartalldelete(writer);
	}

	//�α��� �� ������� �ֹ� ����Ʈ
	@Override
	public List<Book_OrderVO> orderList(Book_OrderVO order) throws Exception {
		return cm.orderList(order);
	}

	//�ֹ� ��ȣ�� ���� �� ����
	@Override
	public List<OrderListDetailVO> orderlistdetail(Book_OrderVO order) throws Exception {
		return cm.orderlistdetail(order);
	}
	
}
