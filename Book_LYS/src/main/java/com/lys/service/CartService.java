package com.lys.service;

import java.util.List;

import com.lys.model.Book_OrderDetailsVO;
import com.lys.model.Book_OrderVO;
import com.lys.model.CartVO;
import com.lys.model.OrderListDetailVO;

public interface CartService {
	
	//īƮ ���
	public void cartinsert(CartVO cart) throws Exception;
	
	//īƮ ��ǰ ���� Ȯ�� �ϱ�
	public int countcart(int bookno , String writer)throws Exception;
	
	//īƮ ����Ʈ
	public List<CartVO> listcart(String writer)throws Exception;
	
	//īƮ ��ü �ݾ�
	public int sumMoney(String writer)throws Exception;
	
	//īƮ ��ǰ ����
	public void deletecart(int cart_id)throws Exception;
	
	//īƮ ����
	public int modifycart(CartVO cart)throws Exception;
	
	//īƮ ��ǰ �߰� �� ���� ����
	public void updatecart(CartVO cart)throws Exception;
	
	//�ֹ� ����
	public void orderinfo(Book_OrderVO order)throws Exception;
	
	//�ֹ� �� ����
	public void orderinfo_detail(Book_OrderDetailsVO orderdetail)throws Exception;
	
	//�ֹ� �� īƮ ����Ʈ ����
	public void cartalldelete(String writer)throws Exception;
	
	//�α��� �� ���� �ֹ� ����Ʈ
	public List<Book_OrderVO> orderList(Book_OrderVO order)throws Exception;
	
	//�ֹ� ��ȣ�� ���� �� ���� ����Ʈ
	public List<OrderListDetailVO> orderlistdetail(Book_OrderVO order)throws Exception;
}
