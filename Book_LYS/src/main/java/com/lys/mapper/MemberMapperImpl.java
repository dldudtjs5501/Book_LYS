package com.lys.mapper;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.lys.model.MemberVO;

@Repository
public class MemberMapperImpl implements MemberMapper{

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace="com.lys.mapper.MemberMapper";
	
	//ȸ�� ���� ���
	@Override
	public void Mregister(MemberVO member) throws Exception {
		sqlSession.insert(namespace+".register",member);
		
	}
	
	// ���̵� �ߺ� üũ
	@Override
	public int idchk(MemberVO member) throws Exception {
		int result = sqlSession.selectOne(namespace+".idcheck",member);
		return result;
	}
	
	//�α��� üũ
	@Override
	public MemberVO loginCheck(MemberVO member) throws Exception {
		
		return sqlSession.selectOne(namespace+".loginchk",member);
		
	}
	//ȸ�� �� ����
	@Override
	public MemberVO accdetail(String userid) throws Exception {
		MemberVO memberdao = sqlSession.selectOne(namespace+".accdetail",userid);
		return  memberdao;
	}
	//ȸ�� ���� ����
	@Override
	public void accmodify(MemberVO member) throws Exception {
		sqlSession.update(namespace+".accmodify",member);
		
	}
	
	//id ã�� - email �� ��������
	@Override
	public MemberVO findid(MemberVO member) throws Exception {
		System.out.println("�̸��� mapper");
		System.out.println("mapper : "+member.toString());
		return sqlSession.selectOne(namespace+".findid",member);	
	}
	
	//���� ��ȣ ���� �� ��� ��ȣ ���� - ȸ�� Ȯ��
	@Override
	public int findmem(MemberVO member) throws Exception {
		int result = sqlSession.selectOne(namespace+".modifypw",member);
		return result;
	}
	
	//password ���� �� ����
	@Override
	public void pass_change(MemberVO member, Map<String, Object> map) throws Exception {
		
		map.get("password");
		map.get("email");
		sqlSession.update(namespace+".pass_change",map);
	}

	//ȸ�� Ż��
	@Override
	public void memberdel(MemberVO member) throws Exception {
		sqlSession.delete(namespace+".memberdel",member);
	}

}
