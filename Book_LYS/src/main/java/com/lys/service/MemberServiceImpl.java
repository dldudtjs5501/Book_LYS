package com.lys.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lys.mapper.MemberMapper;
import com.lys.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberMapper mm;
	
	//ȸ�� ���� ���
	@Override
	public void Mregister(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		mm.Mregister(member);
	}
	
	//���̵� �ߺ� üũ
	@Override
	public int idchk(MemberVO member) throws Exception {
		
		int result = mm.idchk(member);
		return result;
	}
	//�α��� üũ
	@Override
	public MemberVO loginCheck(MemberVO member) throws Exception {
		
		return mm.loginCheck(member);
		
	}
	//ȸ�� �� ���� 
	@Override
	public MemberVO accdetail(String userid) throws Exception {
		return mm.accdetail(userid);
	}
	//ȸ�� ���� ����
	@Override
	public void accmodify(MemberVO member) throws Exception {
		
		mm.accmodify(member);	
	}
	
	//�̸��� ����ȣ�� ���� ȸ�� ���� 
	@Override
	public MemberVO findid(MemberVO member) throws Exception {
		
		System.out.println("�̸��� service ����.....");
		
		return mm.findid(member);	
	}
	
	//���� ��ȣ ���� �� ��� ��ȣ ���� - ȸ�� Ȯ��
	@Override
	public int findmem(MemberVO member) throws Exception {
		int result = mm.findmem(member);
		return result;
	}

	//password ���� �� ����
	@Override
	public void pass_change(MemberVO member, Map<String, Object> map) throws Exception {
		mm.pass_change(member, map);
		
	}

	//ȸ�� Ż��
	@Override
	public void memberdel(MemberVO member) throws Exception {
		mm.memberdel(member);
		
	}
}
