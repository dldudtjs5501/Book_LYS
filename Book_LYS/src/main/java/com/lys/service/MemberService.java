package com.lys.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lys.model.MemberVO;

public interface MemberService {
	
	//ȸ�� ���� ���
	public void Mregister(MemberVO member) throws Exception;
	
	//���̵� �ߺ� üũ
	public int idchk(MemberVO member) throws Exception;
	
	//�α��� üũ
	public MemberVO loginCheck(MemberVO member) throws Exception;
	
	//ȸ�� ���� detail
	public MemberVO accdetail(String userid) throws Exception;
	
	//ȸ�� ���� ����
	public void accmodify(MemberVO member) throws Exception;
	
	//id ã�� - email ���� ��������
	public MemberVO findid(MemberVO member) throws Exception;
	
	//���� ��ȣ ���� �� ��� ��ȣ ���� - ȸ�� Ȯ��
	public int findmem(MemberVO member)throws Exception;
	
	//password ���� �� ����
	public void pass_change(MemberVO member,Map<String,Object>map)throws Exception;

	//ȸ�� Ż��
	public void memberdel(MemberVO member)throws Exception;
}
